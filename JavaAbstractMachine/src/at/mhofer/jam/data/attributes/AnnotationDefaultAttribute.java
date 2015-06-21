package at.mhofer.jam.data.attributes;

public class AnnotationDefaultAttribute extends AttributeInfo
{
	private ElementValue defaultValue;

	public AnnotationDefaultAttribute(int attributeNameIndex, long attributeLength,
			ElementValue defaultValue)
	{
		super(attributeNameIndex, attributeLength);
		this.defaultValue = defaultValue;
	}

	public ElementValue getDefaultValue()
	{
		return defaultValue;
	}
}
