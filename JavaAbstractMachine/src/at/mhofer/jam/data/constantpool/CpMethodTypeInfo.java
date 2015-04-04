package at.mhofer.jam.data.constantpool;

public class CpMethodTypeInfo implements CpInfo
{

	/**
	 * The value of the descriptor_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) representing a method descriptor
	 * (§4.3.3).
	 */
	private short descriptorInfo;

	public CpMethodTypeInfo(short descriptorInfo)
	{
		this.descriptorInfo = descriptorInfo;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.METHOD_TYPE;
	}

	public short getDescriptorInfo()
	{
		return descriptorInfo;
	}

}
