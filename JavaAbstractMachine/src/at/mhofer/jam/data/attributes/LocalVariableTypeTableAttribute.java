package at.mhofer.jam.data.attributes;

/**
 * The LocalVariableTypeTable attribute is an optional variable-length attribute
 * in the attributes table of a Code attribute (§4.7.3). It may be used by
 * debuggers to determine the value of a given local variable during the
 * execution of a method.
 * 
 * If multiple LocalVariableTypeTable attributes are present in the attributes
 * table of a given Code attribute, then they may appear in any order.
 * 
 * There may be no more than one LocalVariableTypeTable attribute per local
 * variable in the attributes table of a Code attribute.
 * 
 * 
 * @author Mathias
 *
 */
public class LocalVariableTypeTableAttribute extends AttributeInfo
{
	/**
	 * The value of the local_variable_type_table_length item indicates the
	 * number of entries in the local_variable_type_table array.
	 */
	private int localVariableTypeTableLength;

	/**
	 * Each entry in the local_variable_type_table array indicates a range of
	 * code array offsets within which a local variable has a value. It also
	 * indicates the index into the local variable array of the current frame at
	 * which that local variable can be found.
	 */
	private LocalVariableTypeTableEntry[] localVariableTypeTable;

	public LocalVariableTypeTableAttribute(int attributeNameIndex, long attributeLength,
			int localVariableTypeTableLength, LocalVariableTypeTableEntry[] localVariableTypeTable)
	{
		super(attributeNameIndex, attributeLength);
		this.localVariableTypeTableLength = localVariableTypeTableLength;
		this.localVariableTypeTable = localVariableTypeTable;
	}

	public int getLocalVariableTypeTableLength()
	{
		return localVariableTypeTableLength;
	}

	public LocalVariableTypeTableEntry[] getLocalVariableTypeTable()
	{
		return localVariableTypeTable;
	}
}
