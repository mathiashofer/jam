package at.mhofer.jam.data.attributes;

public class RuntimeVisibleAnnotationsAttribute extends AttributeInfo
{
	/**
	 * The value of the num_annotations item gives the number of run-time
	 * visible annotations represented by the structure.
	 */
	private int numAnnotations;

	/**
	 * Each entry in the annotations table represents a single run-time visible
	 * annotation on a declaration.
	 */
	private AnnotationTableEntry[] annotations;

	public RuntimeVisibleAnnotationsAttribute(int attributeNameIndex, long attributeLength,
			int numAnnotations, AnnotationTableEntry[] annotations)
	{
		super(attributeNameIndex, attributeLength);
		this.numAnnotations = numAnnotations;
		this.annotations = annotations;
	}

	public int getNumAnnotations()
	{
		return numAnnotations;
	}

	public AnnotationTableEntry[] getAnnotations()
	{
		return annotations;
	}
}
