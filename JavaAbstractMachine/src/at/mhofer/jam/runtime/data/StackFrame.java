package at.mhofer.jam.runtime.data;

import java.util.Stack;

import at.mhofer.jam.data.constantpool.ConstantPoolInfo;
import at.mhofer.jam.runtime.data.operands.Operand;

public class StackFrame
{
	
	private ConstantPoolInfo[] constantPool;
	
	private Stack<DataType> operandStack;
		
	private DataType[] localVariables;

	public StackFrame(ConstantPoolInfo[] constantPool, Stack<DataType> operandStack,
			Operand[] localVariables)
	{
		super();
		this.constantPool = constantPool;
		this.operandStack = operandStack;
		this.localVariables = localVariables;
	}

	public StackFrame(ConstantPoolInfo[] constantPool, DataType[] localVariables)
	{
		super();
		this.constantPool = constantPool;
		this.operandStack = new Stack<DataType>();
		this.localVariables = localVariables;
	}

	public DataType push(DataType operand)
	{
		return operandStack.push(operand);
	}
	
	public DataType pop()
	{
		return operandStack.pop();
	}
	
	public Operand popOperand()
	{
		//TODO: type safety
		Operand popped = (Operand) operandStack.pop();
		return popped;
	}

	public ConstantPoolInfo[] getConstantPool()
	{
		return constantPool;
	}

	public Stack<DataType> getOperandStack()
	{
		return operandStack;
	}

	public DataType[] getLocalVariables()
	{
		return localVariables;
	}
	
	public DataType getLocalVariableAt(int index)
	{
		return localVariables[index];
	}
	
	public void setLocalVariableAt(int index, DataType variable)
	{
		this.localVariables[index] = variable;
	}
	
	public Reference getLocalReferenceAt(int index)
	{
		//TODO: type safety
		return (Reference) getLocalVariableAt(index);
	}
	
	public Operand getLocalOperandAt(int index)
	{
		//TODO: type safety
		return (Operand) getLocalVariableAt(index);
	}
	
	public void setLocalVariableAt(DataType variable, int index)
	{
		this.localVariables[index] = variable;
	}
	
	public void printLocalVariables()
	{
		for (DataType local : localVariables)
		{
			System.out.println(local);
		}
	}

	public void printOperandStack()
	{
		for (DataType op : operandStack)
		{
			System.out.println(op);
		}
	}
	
}
