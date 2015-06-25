package at.mhofer.jam.runtime.data;

import java.util.Stack;

import at.mhofer.jam.data.constantpool.ConstantPoolInfo;
import at.mhofer.jam.runtime.data.operands.Operand;

public class StackFrame
{
	
	private ConstantPoolInfo[] constantPool;
	
	private Stack<Operand<?>> operandStack;
		
	private Operand<?>[] localVariables;

	public StackFrame(ConstantPoolInfo[] constantPool, Stack<Operand<?>> operandStack,
			Operand<?>[] localVariables)
	{
		super();
		this.constantPool = constantPool;
		this.operandStack = operandStack;
		this.localVariables = localVariables;
	}

	public StackFrame(ConstantPoolInfo[] constantPool, Operand<?>[] localVariables)
	{
		super();
		this.constantPool = constantPool;
		this.operandStack = new Stack<>();
		this.localVariables = localVariables;
	}

	

	public Operand<?> pushOperand(Operand<?> operand)
	{
		return operandStack.push(operand);
	}
	
	public Operand<?> popOperand()
	{
		Operand<?> popped = operandStack.pop();
		return popped;
	}

	public ConstantPoolInfo[] getConstantPool()
	{
		return constantPool;
	}

	public Stack<Operand<?>> getOperandStack()
	{
		return operandStack;
	}

	public Operand<?>[] getLocalVariables()
	{
		return localVariables;
	}
	
	public void printLocalVariables()
	{
		for (Operand<?> local : localVariables)
		{
			System.out.println(local);
		}
	}

	public void printOperandStack()
	{
		for (Operand<?> op : operandStack)
		{
			System.out.println(op);
		}
	}
	
}
