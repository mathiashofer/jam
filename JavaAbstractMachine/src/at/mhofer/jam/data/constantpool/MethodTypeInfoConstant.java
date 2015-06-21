package at.mhofer.jam.data.constantpool;

public class MethodTypeInfoConstant implements ConstantPoolInfo
{

	/**
	 * The value of the descriptor_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) representing a method descriptor
	 * (§4.3.3).
	 */
	private int descriptorIndex;

	public MethodTypeInfoConstant(int descriptorIndex)
	{
		this.descriptorIndex = descriptorIndex;
	}

	@Override
	public ConstantPoolTag getTag()
	{
		return ConstantPoolTag.METHOD_TYPE;
	}

	public int getDescriptorIndex()
	{
		return descriptorIndex;
	}

}
