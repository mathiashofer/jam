package at.mhofer.jam.data.constantpool;

public class CpInterfaceMethodrefInfo implements CpInfo
{
	/**
	 * The value of the class_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Class_info structure (§4.4.1) representing a class or interface
	 * type that has the field or method as a member.
	 * 
	 * The class_index item of a CONSTANT_InterfaceMethodref_info structure must
	 * be an interface type.
	 */
	private int classIndex;

	/**
	 * The value of the name_and_type_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_NameAndType_info structure (§4.4.6). This constant_pool entry
	 * indicates the name and descriptor of the field or method.
	 * 
	 * The indicated descriptor must be a method descriptor (§4.3.3).
	 */
	private int nameAndTypeIndex;

	public CpInterfaceMethodrefInfo(int classIndex, int nameAndTypeIndex)
	{
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.INTERFACE_METHODREF;
	}

	public int getClassIndex()
	{
		return classIndex;
	}

	public int getNameAndTypeIndex()
	{
		return nameAndTypeIndex;
	}
}
