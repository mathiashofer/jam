package at.mhofer.jam.data.attributes;

public class CodeAttribute extends AttributeInfo
{
	private int maxStack;
	
	private int maxLocals;
	
	private long codeLength;
	
	//TODO: change to U4Array
	private byte[] code;
	
	private int exceptionTableLength;
	
	private ExceptionIndexTableEntry[] exceptionTable;
	
	private int attributesCount;
	
	private AttributeInfo[] attributes;

	public CodeAttribute(int attributeNameIndex, long attributeLength, int maxStack, int maxLocals,
			long codeLength, byte[] code, int exceptionTableLength, ExceptionIndexTableEntry[] exceptionTable,
			int attributesCount, AttributeInfo[] attributes)
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

	public byte[] getCode()
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
