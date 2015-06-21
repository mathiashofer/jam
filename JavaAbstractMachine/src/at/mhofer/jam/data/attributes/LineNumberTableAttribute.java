package at.mhofer.jam.data.attributes;

public class LineNumberTableAttribute extends AttributeInfo
{
	/**
	 * The value of the line_number_table_length item indicates the number of
	 * entries in the line_number_table array.
	 */
	private int lineNumberTableLength;

	/**
	 * Each entry in the line_number_table array indicates that the line number
	 * in the original source file changes at a given point in the code array.
	 */
	private LineNumberTableEntry[] lineNumberTable;
	
	public LineNumberTableAttribute(int attributeNameIndex, long attributeLength,
			int lineNumberTableLength, LineNumberTableEntry[] lineNumberTable)
	{
		super(attributeNameIndex, attributeLength);
		this.lineNumberTableLength = lineNumberTableLength;
		this.lineNumberTable = lineNumberTable;
	}
	
	public int getLineNumberTableLength()
	{
		return lineNumberTableLength;
	}
	
	public LineNumberTableEntry[] getLineNumberTable()
	{
		return lineNumberTable;
	}
}
