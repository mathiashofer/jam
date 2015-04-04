package at.mhofer.jam.data.constantpool;

public class CpMethodrefInfo implements CpInfo
{

	/**
	 * The value of the class_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Class_info structure (§4.4.1) representing a class or interface
	 * type that has the field or method as a member.
	 * 
	 * The class_index item of a CONSTANT_Methodref_info structure must be a
	 * class type, not an interface type.
	 */
	private short classIndex;

	/**
	 * The value of the name_and_type_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_NameAndType_info structure (§4.4.6). This constant_pool entry
	 * indicates the name and descriptor of the field or method.
	 * 
	 * The indicated descriptor must be a method descriptor (§4.3.3).
	 * 
	 * If the name of the method of a CONSTANT_Methodref_info structure begins
	 * with a '<' ('\u003c'), then the name must be the special name <init>,
	 * representing an instance initialization method (§2.9). The return type of such
	 * a method must be void.
	 */
	private short nameAndTypeIndex;

	public CpMethodrefInfo(short classIndex, short nameAndTypeIndex)
	{
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.METHODREF;
	}

	public short getClassIndex()
	{
		return classIndex;
	}

	public short getNameAndTypeIndex()
	{
		return nameAndTypeIndex;
	}

}
