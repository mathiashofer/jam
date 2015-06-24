package at.mhofer.jam.runtime.data;

import java.util.Stack;

import at.mhofer.jam.data.constantpool.ConstantPoolInfo;
import at.mhofer.jam.runtime.data.variables.Variable;

public class StackFrame
{
	
	private ConstantPoolInfo[] constantPool;
	
	private Stack<Variable> operandStack;
	
	private Variable[] localVariables;

	public StackFrame(ConstantPoolInfo[] constantPool, Stack<Variable> operandStack,
			Variable[] localVariables)
	{
		super();
		this.constantPool = constantPool;
		this.operandStack = operandStack;
		this.localVariables = localVariables;
	}

	public ConstantPoolInfo[] getConstantPool()
	{
		return constantPool;
	}

	public Stack<Variable> getOperandStack()
	{
		return operandStack;
	}

	public Variable[] getLocalVariables()
	{
		return localVariables;
	}

}
