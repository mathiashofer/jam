package at.mhofer.jam.data.attributes;

public class ExceptionsAttribute extends AttributeInfo
{
	/**
	 * The value of the number_of_exceptions item indicates the number of
	 * entries in the exception_index_table.
	 */
	private int numberOfExceptions;

	/**
	 * Each value in the exception_index_table array must be a valid index into
	 * the constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Class_info structure (§4.4.1) representing a class type that
	 * this method is declared to throw.
	 */
	private int[] exceptionIndexTable;

	public ExceptionsAttribute(int attributeNameIndex, long attributeLength,
			int numberOfExceptions, int[] exceptionIndexTable)
	{
		super(attributeNameIndex, attributeLength);
		this.numberOfExceptions = numberOfExceptions;
		this.exceptionIndexTable = exceptionIndexTable;
	}

	public int getNumberOfExceptions()
	{
		return numberOfExceptions;
	}

	public int[] getExceptionIndexTable()
	{
		return exceptionIndexTable;
	}
}
