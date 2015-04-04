package at.mhofer.jam.data.constantpool;

public class CpStringInfo implements CpInfo
{

	/**
	 * The value of the string_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) representing the sequence of
	 * Unicode code points to which the String object is to be initialized.
	 */
	private short stringIndex;

	public CpStringInfo(short stringIndex)
	{
		this.stringIndex = stringIndex;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.STRING;
	}

	public short getStringIndex()
	{
		return stringIndex;
	}

}
