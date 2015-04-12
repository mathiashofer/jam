package at.mhofer.jam.data.attributes;

public class AttributeInfo
{

	/**
	 * For all attributes, the attribute_name_index must be a valid unsigned 16-
	 * bit index into the constant pool of the class. The constant_pool entry at
	 * attribute_name_index must be a CONSTANT_Utf8_info structure (§4.4.7)
	 * representing the name of the attribute.
	 */
	private int attributeNameIndex;

	/**
	 * The value of the attribute_length item indicates the length of the
	 * subsequent information in bytes. The length does not include the initial
	 * six bytes that contain the attribute_name_index and attribute_length
	 * items.
	 */
	private int attributeLength;

	private byte[] info;

	public AttributeInfo(int attributeNameIndex, int attributeLength, byte[] info)
	{
		super();
		this.attributeNameIndex = attributeNameIndex;
		this.attributeLength = attributeLength;
		this.info = info;
	}

	public int getAttributeNameIndex()
	{
		return attributeNameIndex;
	}

	public void setAttributeNameIndex(int attributeNameIndex)
	{
		this.attributeNameIndex = attributeNameIndex;
	}

	public int getAttributeLength()
	{
		return attributeLength;
	}

	public void setAttributeLength(int attributeLength)
	{
		this.attributeLength = attributeLength;
	}

	public byte[] getInfo()
	{
		return info;
	}

	public void setInfo(byte[] info)
	{
		this.info = info;
	}
	
}
