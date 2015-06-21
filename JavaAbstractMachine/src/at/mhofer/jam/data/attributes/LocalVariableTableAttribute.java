package at.mhofer.jam.data.attributes;

public class LocalVariableTableAttribute extends AttributeInfo
{
	/**
	 * The value of the local_variable_table_length item indicates the number of
	 * entries in the local_variable_table array.
	 */
	private int localVariableTableLength;

	/**
	 * Each entry in the local_variable_table array indicates a range of code
	 * array offsets within which a local variable has a value. It also
	 * indicates the index into the local variable array of the current frame at
	 * which that local variable can be found.
	 */
	private LocalVariableTableEntry[] localVariableTable;

	public LocalVariableTableAttribute(int attributeNameIndex, long attributeLength,
			int localVariableTableLength, LocalVariableTableEntry[] localVariableTable)
	{
		super(attributeNameIndex, attributeLength);
		this.localVariableTableLength = localVariableTableLength;
		this.localVariableTable = localVariableTable;
	}

	public int getLocalVariableTableLength()
	{
		return localVariableTableLength;
	}

	public LocalVariableTableEntry[] getLocalVariableTable()
	{
		return localVariableTable;
	}
}
