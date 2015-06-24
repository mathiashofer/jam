package at.mhofer.jam.runtime;

import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import at.mhofer.jam.data.ClassFile;
import at.mhofer.jam.data.U4Array;
import at.mhofer.jam.data.attributes.CodeAttribute;
import at.mhofer.jam.data.attributes.LocalVariableTableAttribute;
import at.mhofer.jam.data.constantpool.ConstantPoolInfo;
import at.mhofer.jam.data.methods.MethodInfo;
import at.mhofer.jam.runtime.data.StackFrame;

public class Processor implements Runnable, OpCodes
{
	private Logger logger = LogManager.getLogger(Processor.class);

	private MethodInfo currentMethod;

	private Stack<StackFrame> stack = new Stack<StackFrame>();

	private ClassFile clazz;

	/**
	 * Program counter
	 */
	private int pc;

	private U4Array<Byte> instructions;

	public Processor(ClassFile clazz)
	{
		this.clazz = clazz;
		this.currentMethod = clazz.getInitMethod();
		invokeMethod(currentMethod, clazz);
	}

	public void invokeMethod(MethodInfo method, ConstantPoolInfo[] constantPool)
	{
		CodeAttribute code = method.getCodeAttribute();
		LocalVariableTableAttribute localVariables = code.getLocalVariableTableAttribute();
		
		StackFrame frame = new StackFrame(constantPool, localVariables);
		stack.push(frame);
		
		this.instructions = code != null ? code.getCode() : null;
	}
	
	public void invokeMethod(MethodInfo method, ClassFile clazz)
	{
		CodeAttribute code = method.getCodeAttribute();
		LocalVariableTableAttribute localVariables = code.getLocalVariableTableAttribute();
		ConstantPoolInfo[] constantPool = clazz.getConstantPool();
		
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
			Byte instruction = instructions.get(pc);

			// decode
			switch (instruction)
			{
			
			default:
				logger.warn("OpCode {} is not supported!", instruction);
			}

			// next instruction
			pc = pc + 1;
		}
	}

}
