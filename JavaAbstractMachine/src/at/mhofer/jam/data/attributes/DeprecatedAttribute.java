package at.mhofer.jam.data.attributes;

/**
 * The Deprecated attribute is an optional fixed-length attribute in the
 * attributes table of a ClassFile, field_info, or method_info structure (§4.1,
 * §4.5, §4.6). A class, interface, method, or field may be marked using a
 * Deprecated attribute to indicate that the class, interface, method, or field
 * has been superseded.
 * 
 * A run-time interpreter or tool that reads the class file format, such as a
 * compiler, can use this marking to advise the user that a superseded class,
 * interface, method, or field is being referred to. The presence of a
 * Deprecated attribute does not alter the semantics of a class or interface.
 * 
 * @author Mathias
 *
 */
public class DeprecatedAttribute extends AttributeInfo
{
	public DeprecatedAttribute(int attributeNameIndex, long attributeLength)
	{
		super(attributeNameIndex, attributeLength);
	}
}
