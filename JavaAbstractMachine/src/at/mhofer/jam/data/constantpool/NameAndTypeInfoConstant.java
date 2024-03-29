package at.mhofer.jam.data.constantpool;

public class NameAndTypeInfoConstant implements ConstantPoolInfo
{

	/**
	 * The value of the name_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (�4.4.7) representing either the special
	 * method name <init> (�2.9) or a valid unqualified name denoting a field or
	 * method (�4.2.2).
	 */
	private int nameIndex;

	/**
	 * The value of the descriptor_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (�4.4.7) representing a valid field
	 * descriptor or method descriptor (�4.3.2, �4.3.3).
	 */
	private int descriptorIndex;

	public NameAndTypeInfoConstant(int nameIndex, int descriptorIndex)
	{
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
	}

	@Override
	public ConstantPoolTag getTag()
	{
		return ConstantPoolTag.NAME_AND_TYPE;
	}

	public int getNameIndex()
	{
		return nameIndex;
	}

	public int getDescriptorIndex()
	{
		return descriptorIndex;
	}

}
