package at.mhofer.jam.data.attributes;

public class ConstantValueAttribute extends AttributeInfo
{
	
	private int constantValueIndex;
	
	public ConstantValueAttribute(int attributeNameIndex, long attributeLength, int constantValueIndex)
	{
		super(attributeNameIndex, attributeLength);
		this.constantValueIndex = constantValueIndex;
	}

	public int getConstantValueIndex()
	{
		return constantValueIndex;
	}

}
