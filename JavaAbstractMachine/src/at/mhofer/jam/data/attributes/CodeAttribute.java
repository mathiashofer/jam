package at.mhofer.jam.data.attributes;

import at.mhofer.jam.data.U4Array;

public class CodeAttribute extends AttributeInfo
{
	private int maxStack;
	
	private int maxLocals;
	
	private long codeLength;
	
	private U4Array<Byte> code;
	
	private int exceptionTableLength;
	
	private ExceptionIndexTableEntry[] exceptionTable;
	
	private int attributesCount;
	
	private AttributeInfo[] attributes;
	
	private LocalVariableTableAttribute localVariableTableAttribute;

	public CodeAttribute(int attributeNameIndex, long attributeLength, int maxStack, int maxLocals,
			long codeLength, U4Array<Byte> code, int exceptionTableLength, ExceptionIndexTableEntry[] exceptionTable,
			int attributesCount, AttributeInfo[] attributes, LocalVariableTableAttribute localVariableTableAttribute)
	{
		super(attributeNameIndex, attributeLength);
		this.maxStack = maxStack;
		this.maxLocals = maxLocals;
		this.codeLength = codeLength;
		this.code = code;
		this.exceptionTableLength = exceptionTableLength;
		this.exceptionTable = exceptionTable;
		this.attributesCount = attributesCount;
		this.attributes = attributes;
		this.localVariableTableAttribute = localVariableTableAttribute;
	}
	
	public LocalVariableTableAttribute getLocalVariableTableAttribute()
	{
		return localVariableTableAttribute;
	}

	public int getMaxStack()
	{
		return maxStack;
	}

	public int getMaxLocals()
	{
		return maxLocals;
	}

	public long getCodeLength()
	{
		return codeLength;
	}

	public U4Array<Byte> getCode()
	{
		return code;
	}

	public int getExceptionTableLength()
	{
		return exceptionTableLength;
	}

	public ExceptionIndexTableEntry[] getExceptionTable()
	{
		return exceptionTable;
	}

	public int getAttributesCount()
	{
		return attributesCount;
	}

	public AttributeInfo[] getAttributes()
	{
		return attributes;
	}
}
