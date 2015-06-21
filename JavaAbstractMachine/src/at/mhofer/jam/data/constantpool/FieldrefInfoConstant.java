package at.mhofer.jam.data.constantpool;

public class FieldrefInfoConstant implements ConstantPoolInfo
{

	/**
	 * The value of the class_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Class_info structure (§4.4.1) representing a class or interface
	 * type that has the field or method as a member.
	 * 
	 * The class_index item of a CONSTANT_Fieldref_info structure may be either
	 * a class type or an interface type.
	 */
	private int classIndex;

	/**
	 * The value of the name_and_type_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_NameAndType_info structure (§4.4.6). This constant_pool entry
	 * indicates the name and descriptor of the field or method.
	 * 
	 * In a CONSTANT_Fieldref_info, the indicated descriptor must be a field
	 * descriptor (§4.3.2).
	 */
	private int nameAndTypeIndex;

	public FieldrefInfoConstant(int classIndex, int nameAndTypeIndex)
	{
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	@Override
	public ConstantPoolTag getTag()
	{
		return ConstantPoolTag.FIELDREF;
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
