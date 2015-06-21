package at.mhofer.jam.data.attributes;

public class StackMapTableAttribute extends AttributeInfo
{
	/**
	 * The value of the number_of_entries item gives the number of
	 * stack_map_frame entries in the entries table.
	 */
	private int numberOfEntries;

	/**
	 * Each entry in the entries table describes one stack map frame of the
	 * method. The order of the stack map frames in the entries table is
	 * significant.
	 */
	private StackMapFrame[] entries;

	public StackMapTableAttribute(int attributeNameIndex, long attributeLength,
			int numberOfEntries, StackMapFrame[] entries)
	{
		super(attributeNameIndex, attributeLength);
		this.numberOfEntries = numberOfEntries;
		this.entries = entries;
	}

	public int getNumberOfEntries()
	{
		return numberOfEntries;
	}

	public StackMapFrame[] getEntries()
	{
		return entries;
	}
}
