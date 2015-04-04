package at.mhofer.jam.data.constantpool;

public class CpNameAndTypeInfo implements CpInfo
{

	/**
	 * The value of the name_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) representing either the special
	 * method name <init> (§2.9) or a valid unqualified name denoting a field or
	 * method (§4.2.2).
	 */
	private short nameIndex;

	/**
	 * The value of the descriptor_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) representing a valid field
	 * descriptor or method descriptor (§4.3.2, §4.3.3).
	 */
	private short descriptorIndex;

	public CpNameAndTypeInfo(short nameIndex, short descriptorIndex)
	{
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.NAME_AND_TYPE;
	}

	public short getNameIndex()
	{
		return nameIndex;
	}

	public short getDescriptorIndex()
	{
		return descriptorIndex;
	}

}
