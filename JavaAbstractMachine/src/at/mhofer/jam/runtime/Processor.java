package at.mhofer.jam.runtime;

import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import at.mhofer.jam.data.ClassFile;
import at.mhofer.jam.data.U4Array;
import at.mhofer.jam.data.attributes.CodeAttribute;
import at.mhofer.jam.data.attributes.LocalVariableTableAttribute;
import at.mhofer.jam.data.attributes.LocalVariableTableEntry;
import at.mhofer.jam.data.constantpool.ConstantPoolInfo;
import at.mhofer.jam.data.methods.MethodInfo;
import at.mhofer.jam.runtime.data.DataType;
import at.mhofer.jam.runtime.data.Reference;
import at.mhofer.jam.runtime.data.StackFrame;
import at.mhofer.jam.runtime.data.operands.DoubleOperand;
import at.mhofer.jam.runtime.data.operands.FloatOperand;
import at.mhofer.jam.runtime.data.operands.IntOperand;
import at.mhofer.jam.runtime.data.operands.LongOperand;
import at.mhofer.jam.runtime.data.operands.Operand;
import at.mhofer.jam.util.OpCodeUtil;

public class Processor implements Runnable, OpCodes
{
	private Logger logger = LogManager.getLogger(Processor.class);

	private MethodInfo currentMethod;

	private Stack<StackFrame> stack = new Stack<StackFrame>();

	private ClassFile thisClass;

	/**
	 * Program counter
	 */
	private int pc;

	private U4Array<Byte> instructions;

	public Processor(ClassFile clazz)
	{
		this.thisClass = clazz;
		this.currentMethod = clazz.getMainMethod();
		invokeMethod(currentMethod, clazz);
	}

	@Override
	public void run()
	{
		if (instructions == null)
		{
			logger.error("There are no instructions to process!");
			return;
		}

		while (pc < instructions.getLength())
		{

			// fetch
			int instruction = instructions.get(pc) & 0xFF;

			logger.info("Fetched instruction {} ({}) from PC {}",
					OpCodeUtil.nameByValue(instruction), instruction, pc);

			StackFrame frame = stack.peek();

			Operand operand1 = null;
			Operand operand2 = null;
			Operand local = null;

			// execute
			switch (instruction)
			{
			case BIPUSH:
				int immediate = instructions.get(pc + 1);
				frame.push(new IntOperand(immediate));
				pc += 1;
				break;
			case GOTO:
				byte branchByte1 = instructions.get(pc + 1);
				byte branchByte2 = instructions.get(pc + 2);
				int branchOffset = ((branchByte1 << 8) | branchByte2);
				// -1 because the pc gets increased by 1 after the execution
				pc = pc + branchOffset - 1;
				break;
			case IADD:
				operand1 = frame.popOperand();
				operand2 = frame.popOperand();
				frame.push(operand1.add(operand2));
				break;
			case IINC:
				int index = instructions.get(pc + 1) & 0xFF; // unsigned
				int iconst = instructions.get(pc + 2);
				local = frame.getLocalOperandAt(index);
				local = local.add(iconst);
				frame.setLocalVariableAt(local, index);
				pc += 2;
				break;
			case ALOAD_0:
				Reference ref = frame.getLocalReferenceAt(0);
				frame.push(ref);
				break;
			case ILOAD_0:
				frame.push(frame.getLocalVariableAt(0));
				break;
			case ILOAD_1:
				frame.push(frame.getLocalVariableAt(1));
				break;
			case ILOAD_2:
				frame.push(frame.getLocalVariableAt(2));
				break;
			case IF_ICMPLE:
				operand2 = frame.popOperand();
				operand1 = frame.popOperand();
				if (operand1.le(operand2))
				{
					branchByte1 = instructions.get(pc + 1);
					branchByte2 = instructions.get(pc + 2);
					branchOffset = ((branchByte1 << 8) | branchByte2);
					// -1 because the pc gets increased by 1 after the execution
					pc = pc + branchOffset - 1;
				}
				else
				{
					pc += 2; // skip the branch bytes
				}
				break;
			case NOP:
				break;
			case ACONST_NULL:
				frame.push(Reference.NULL);
				break;
			case RETURN:
				frame.printLocalVariables();
				stack.pop();
				break;
			case ICONST_M1:
				frame.push(IntOperand.MINUS_ONE);
				break;
			case ICONST_0:
				frame.push(IntOperand.ZERO);
				break;
			case ICONST_1:
				frame.push(IntOperand.ONE);
				break;
			case ICONST_2:
				frame.push(IntOperand.TWO);
				break;
			case ICONST_3:
				frame.push(IntOperand.THREE);
				break;
			case ICONST_4:
				frame.push(IntOperand.FOUR);
				break;
			case ICONST_5:
				frame.push(IntOperand.FIVE);
				break;
			case LCONST_0:
				frame.push(LongOperand.ZERO);
				break;
			case LCONST_1:
				frame.push(LongOperand.ONE);
				break;
			case FCONST_0:
				frame.push(FloatOperand.ZERO);
				break;
			case FCONST_1:
				frame.push(FloatOperand.ONE);
				break;
			case DCONST_0:
				frame.push(DoubleOperand.ZERO);
				break;
			case DCONST_1:
				frame.push(DoubleOperand.ONE);
				break;
			case ISTORE_0:
				store(frame, 0);
				break;
			case ISTORE_1:
				store(frame, 1);
				break;
			case ISTORE_2:
				store(frame, 2);
				break;
			case ISTORE_3:
				store(frame, 3);
				break;
			case GETSTATIC:
				index = readIndexBytes(pc);
				frame.printOperandStack();
				frame.printLocalVariables();
				return;
			case INVOKESTATIC:
				
				break;
			default:
				logger.error("Instruction {} is not supported!",
						OpCodeUtil.nameByValue(instruction));
				return;
			}

			// next instruction
			pc = pc + 1;
		}
	}
	
	public void invokeMethod(MethodInfo method, ClassFile clazz)
	{
		CodeAttribute code = method.getCodeAttribute();
		LocalVariableTableAttribute localVariableTable = code.getLocalVariableTableAttribute();
		ConstantPoolInfo[] constantPool = clazz.getConstantPool();

		LocalVariableTableEntry[] entries = localVariableTable.getLocalVariableTable();
		DataType[] localVariables = new DataType[entries.length];
		for (int i = 0; i < entries.length; i++)
		{
			localVariables[i] = new Reference(entries[i].getNameIndex());
		}

		StackFrame frame = new StackFrame(constantPool, localVariables);
		stack.push(frame);

		this.instructions = code != null ? code.getCode() : null;
	}
	
	private void store(StackFrame frame, int index)
	{
		Operand operand = frame.popOperand();
		frame.setLocalVariableAt(index, operand);
	}

	private int readIndexBytes(int pc)
	{
		int indexByte1 = instructions.get(pc + 1);
		int indexByte2 = instructions.get(pc + 2);
		int index = ((indexByte1 << 8) | indexByte2);
		return index;
	}

}
