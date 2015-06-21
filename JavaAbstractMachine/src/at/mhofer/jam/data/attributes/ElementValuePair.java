package at.mhofer.jam.data.attributes;

public class ElementValuePair
{
	/**
	 * The value of the element_name_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7). The constant_pool entry denotes
	 * the name of the element of the element-value pair represented by this
	 * element_value_pairs entry.
	 * 
	 * In other words, the entry denotes an element of the annotation type
	 * specified by type_index.
	 */
	private int elementNameIndex;
	
	private ElementValue value;

	public ElementValuePair(int elementNameIndex, ElementValue value)
	{
		super();
		this.elementNameIndex = elementNameIndex;
		this.value = value;
	}
	
	public int getElementNameIndex()
	{
		return elementNameIndex;
	}
	
	public ElementValue getValue()
	{
		return value;
	}
}
