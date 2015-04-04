package at.mhofer.jam.data.constantpool;

public class CpInvokeDynamicInfo implements CpInfo
{

	/**
	 * The value of the bootstrap_method_attr_index item must be a valid index
	 * into the bootstrap_methods array of the bootstrap method table (§4.7.23)
	 * of this class file.
	 */
	private short bootstrapMethodAttrIndex;

	/**
	 * The value of the name_and_type_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_NameAndType_info structure (§4.4.6) representing a method name
	 * and method descriptor (§4.3.3).
	 */
	private short nameAndTypeIndex;

	public CpInvokeDynamicInfo(short bootstrapMethodAttrIndex, short nameAndTypeIndex)
	{
		this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.INVOKE_DYNAMIC;
	}

	public short getBootstrapMethodAttrIndex()
	{
		return bootstrapMethodAttrIndex;
	}

	public short getNameAndTypeIndex()
	{
		return nameAndTypeIndex;
	}

}
