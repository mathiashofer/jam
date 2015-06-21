package at.mhofer.jam.data.attributes;

/**
 * The RuntimeInvisibleTypeAnnotations attribute is an variable-length attribute
 * in the attributes table of a ClassFile, field_info, or method_info structure,
 * or Code attribute (§4.1, §4.5, §4.6, §4.7.3). The
 * RuntimeInvisibleTypeAnnotations attribute records run-time invisible
 * annotations on types used in the corresponding declaration of a class, field,
 * or method, or in an expression in the corresponding method body. The
 * RuntimeInvisibleTypeAnnotations attribute also records annotations on type
 * parameter declarations of generic classes, interfaces, methods, and
 * constructors.
 * 
 * There may be at most one RuntimeInvisibleTypeAnnotations attribute in the
 * attributes table of a ClassFile, field_info, or method_info structure, or
 * Code attribute.
 * 
 * @author Mathias
 *
 */
public class RuntimeInvisibleTypeAnnotationsAttribute extends AttributeInfo
{
	private int numAnnotations;
	
	private TypeAnnotationsTableEntry[] annotations;

	public RuntimeInvisibleTypeAnnotationsAttribute(int attributeNameIndex, long attributeLength,
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
