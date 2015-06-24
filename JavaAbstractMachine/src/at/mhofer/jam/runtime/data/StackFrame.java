package at.mhofer.jam.runtime.data;

import java.util.Stack;

import at.mhofer.jam.data.attributes.LocalVariableTableAttribute;
import at.mhofer.jam.data.constantpool.ConstantPoolInfo;
import at.mhofer.jam.runtime.data.operands.Operand;

public class StackFrame
{
	
	private ConstantPoolInfo[] constantPool;
	
	private Stack<Operand<?>> operandStack;
		
	private LocalVariableTableAttribute localVariables;

	public StackFrame(ConstantPoolInfo[] constantPool, Stack<Operand<?>> operandStack,
			LocalVariableTableAttribute localVariables)
	{
		super();
		this.constantPool = constantPool;
		this.operandStack = operandStack;
		this.localVariables = localVariables;
	}

	public StackFrame(ConstantPoolInfo[] constantPool, LocalVariableTableAttribute localVariables)
	{
		super();
		this.constantPool = constantPool;
		this.operandStack = new Stack<>();
		this.localVariables = localVariables;
	}



	public ConstantPoolInfo[] getConstantPool()
	{
		return constantPool;
	}

	public Stack<Operand<?>> getOperandStack()
	{
		return operandStack;
	}

	public LocalVariableTableAttribute getLocalVariables()
	{
		return localVariables;
	}

}
