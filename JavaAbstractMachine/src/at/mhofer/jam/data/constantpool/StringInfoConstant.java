package at.mhofer.jam.data.constantpool;

public class StringInfoConstant implements ConstantPoolInfo
{

	/**
	 * The value of the string_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) representing the sequence of
	 * Unicode code points to which the String object is to be initialized.
	 */
	private int stringIndex;

	public StringInfoConstant(int stringIndex)
	{
		this.stringIndex = stringIndex;
	}

	@Override
	public ConstantPoolTag getTag()
	{
		return ConstantPoolTag.STRING;
	}

	public int getStringIndex()
	{
		return stringIndex;
	}

}
