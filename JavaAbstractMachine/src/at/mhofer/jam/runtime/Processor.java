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
import at.mhofer.jam.runtime.data.StackFrame;
import at.mhofer.jam.runtime.data.operands.IntOperand;
import at.mhofer.jam.runtime.data.operands.Operand;
import at.mhofer.jam.runtime.data.operands.ReferenceOperand;
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

	public void invokeMethod(MethodInfo method, ClassFile clazz)
	{
		CodeAttribute code = method.getCodeAttribute();
		LocalVariableTableAttribute localVariableTable = code.getLocalVariableTableAttribute();
		ConstantPoolInfo[] constantPool = clazz.getConstantPool();

		LocalVariableTableEntry[] entries = localVariableTable.getLocalVariableTable();
		Operand<?>[] localVariables = new Operand[entries.length];
		for (int i = 0; i < entries.length; i++)
		{
			localVariables[i] = new ReferenceOperand(entries[i].getNameIndex());
		}

		StackFrame frame = new StackFrame(constantPool, localVariables);
		stack.push(frame);

		this.instructions = code != null ? code.getCode() : null;
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

			IntOperand ioperand1 = null;
			IntOperand ioperand2 = null;
			IntOperand iresult = null;
			IntOperand ilocal = null;

			// decode and execute
			switch (instruction)
			{
			case BIPUSH:
				int immediate = instructions.get(pc + 1);
				frame.pushOperand(new IntOperand(immediate));
				pc += 1;
				break;
			case GOTO:
				byte branchByte1 = instructions.get(pc + 1);
				byte branchByte2 = instructions.get(pc + 2);
				int branchOffset = ((branchByte1 << 8) | branchByte2) & 0xFF;
				// -1 because the pc gets increased by 1 after the execution
				pc = pc + branchOffset - 1;
				break;
			case IADD:
				ioperand1 = (IntOperand) frame.popOperand();
				ioperand2 = (IntOperand) frame.popOperand();
				iresult = new IntOperand(ioperand1.getValue() + ioperand2.getValue());
				frame.pushOperand(iresult);
				break;
			case IINC:
				int index = instructions.get(pc + 1) & 0xFF; // unsigned
				int iconst = instructions.get(pc + 2);
				ilocal = (IntOperand) frame.getLocalVariables()[index];
				ilocal.setValue(ilocal.getValue() + iconst);
				break;
			case ALOAD_0:
				ReferenceOperand ref = (ReferenceOperand) frame.getLocalVariables()[0];
				frame.pushOperand(ref);
				break;
			case ILOAD_2:
				frame.pushOperand(frame.getLocalVariables()[2]);
				break;
			case IF_ICMPLE:
				ioperand1 = (IntOperand) frame.popOperand();
				ioperand2 = (IntOperand) frame.popOperand();
				if (ioperand1.getValue() <= ioperand2.getValue())
				{
					branchByte1 = instructions.get(pc + 1);
					branchByte2 = instructions.get(pc + 2);
					branchOffset = ((branchByte1 << 8) | branchByte2) & 0xFF;
					// -1 because the pc gets increased by 1 after the execution
					pc = pc + branchOffset - 1;
				}
				pc += 2; // skip the branch bytes
				break;
			case RETURN:
				frame.printLocalVariables();
				break;
			case ICONST_M1:
				frame.pushOperand(new IntOperand(-1));
				break;
			case ICONST_0:
				frame.pushOperand(new IntOperand(0));
				break;
			case ICONST_1:
				frame.pushOperand(new IntOperand(1));
				break;
			case ICONST_2:
				frame.pushOperand(new IntOperand(2));
				break;
			case ICONST_3:
				frame.pushOperand(new IntOperand(3));
				break;
			case ICONST_4:
				frame.pushOperand(new IntOperand(4));
				break;
			case ICONST_5:
				frame.pushOperand(new IntOperand(5));
				break;
			case ISTORE_0:
				ioperand1 = (IntOperand) frame.popOperand();
				frame.getLocalVariables()[0] = (IntOperand) ioperand1;
				break;
			case ISTORE_1:
				ioperand1 = (IntOperand) frame.popOperand();
				frame.getLocalVariables()[1] = (IntOperand) ioperand1;
				break;
			case ISTORE_2:
				ioperand1 = (IntOperand) frame.popOperand();
				frame.getLocalVariables()[2] = (IntOperand) ioperand1;
				break;
			case ISTORE_3:
				ioperand1 = (IntOperand) frame.popOperand();
				frame.getLocalVariables()[3] = (IntOperand) ioperand1;
				break;
			case GETSTATIC:
				frame.printOperandStack();
				frame.printLocalVariables();
				return;
			default:
				logger.error("Instruction {} is not supported!",
						OpCodeUtil.nameByValue(instruction));
				return;
			}
			
			// next instruction
			pc = pc + 1;
		}
	}

}
