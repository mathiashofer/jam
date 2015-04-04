package at.mhofer.jam.data.constantpool;

/**
 * See "Table 4.4-A. Constant pool tags" in "The Java(R) Virtual Machine Specification Java SE 8 Edition"
 * 
 * @author Mathias
 *
 */
public enum CpTag
{
	
	CLASS(7),
	FIELDREF(9),
	METHODREF(10),
	INTERFACE_METHODREF(11),
	STRING(8),
	INTEGER(3),
	FLOAT(4),
	LONG(5),
	DOUBLE(6),
	NAME_AND_TYPE(12),
	UTF8(1),
	METHOD_HANDLE(15),
	METHOD_TYPE(16),
	INVOKE_DYNAMIC(18);

	CpTag(int value) { this.value = value; }
	
	private final int value;
	
	public int value() { return value; }
	
}
