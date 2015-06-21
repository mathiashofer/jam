package at.mhofer.jam.data.attributes;

/**
 * The RuntimeInvisibleAnnotations attribute is a variable-length attribute in
 * the attributes table of a ClassFile, field_info, or method_info structure
 * (§4.1, §4.5, §4.6). The RuntimeInvisibleAnnotations attribute records
 * run-time invisible annotations on the declaration of the corresponding class,
 * method, or field.
 * 
 * @author Mathias
 *
 */
public class RuntimeInvisibleAnnotationsAttribute extends AttributeInfo
{
	private int numAnnotations;
	
	private AnnotationTableEntry[] annotations;

	public RuntimeInvisibleAnnotationsAttribute(int attributeNameIndex, long attributeLength,
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
