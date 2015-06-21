package at.mhofer.jam.data.attributes;

/**
 * The SourceFile attribute is an optional fixed-length attribute in the
 * attributes table of a ClassFile structure (§4.1).
 * 
 * There may be at most one SourceFile attribute in the attributes table of a
 * ClassFile structure.
 * 
 * @author Mathias
 *
 */
public class SourceFileAttribute extends AttributeInfo
{
	/**
	 * The value of the sourcefile_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) representing a string.
	 */
	private int sourcefileIndex;

	public SourceFileAttribute(int attributeNameIndex, long attributeLength, int sourcefileIndex)
	{
		super(attributeNameIndex, attributeLength);
		this.sourcefileIndex = sourcefileIndex;
	}

	public int getSourcefileIndex()
	{
		return sourcefileIndex;
	}
}
