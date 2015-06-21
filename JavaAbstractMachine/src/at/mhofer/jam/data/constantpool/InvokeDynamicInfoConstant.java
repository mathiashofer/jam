package at.mhofer.jam.data.constantpool;

public class InvokeDynamicInfoConstant implements ConstantPoolInfo
{

	/**
	 * The value of the bootstrap_method_attr_index item must be a valid index
	 * into the bootstrap_methods array of the bootstrap method table (§4.7.23)
	 * of this class file.
	 */
	private int bootstrapMethodAttrIndex;

	/**
	 * The value of the name_and_type_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_NameAndType_info structure (§4.4.6) representing a method name
	 * and method descriptor (§4.3.3).
	 */
	private int nameAndTypeIndex;

	public InvokeDynamicInfoConstant(int bootstrapMethodAttrIndex, int nameAndTypeIndex)
	{
		this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	@Override
	public ConstantPoolTag getTag()
	{
		return ConstantPoolTag.INVOKE_DYNAMIC;
	}

	public int getBootstrapMethodAttrIndex()
	{
		return bootstrapMethodAttrIndex;
	}

	public int getNameAndTypeIndex()
	{
		return nameAndTypeIndex;
	}

}
