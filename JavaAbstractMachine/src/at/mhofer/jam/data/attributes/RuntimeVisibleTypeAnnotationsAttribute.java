package at.mhofer.jam.data.attributes;

public class RuntimeVisibleTypeAnnotationsAttribute extends AttributeInfo
{
	private int numAnnotations;
	
	private TypeAnnotationsTableEntry[] annotations;

	public RuntimeVisibleTypeAnnotationsAttribute(int attributeNameIndex, long attributeLength,
			int numAnnotations, TypeAnnotationsTableEntry[] annotations)
	{
		super(attributeNameIndex, attributeLength);
		this.numAnnotations = numAnnotations;
		this.annotations = annotations;
	}

	public int getNumAnnotations()
	{
		return numAnnotations;
	}

	public TypeAnnotationsTableEntry[] getAnnotations()
	{
		return annotations;
	}
}
