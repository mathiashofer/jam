package at.mhofer.jam.data.constantpool;

public class CpUTF8Info implements CpInfo
{

	/**
	 * The value of the length item gives the number of bytes in the bytes array
	 * (not the length of the resulting string).
	 */
	private short length;

	/**
	 * The bytes array contains the bytes of the string. No byte may have the
	 * value (byte)0. No byte may lie in the range (byte)0xf0 to (byte)0xff.
	 * 
	 * String content is encoded in modified UTF-8. Modified UTF-8 strings are
	 * encoded so that code point sequences that contain only non-null ASCII
	 * characters can be represented using only 1 byte per code point, but all
	 * code points in the Unicode codespace can be represented. Modified UTF-8
	 * strings are not null-terminated.
	 * 
	 * Look at the specification for further encoding information.
	 */
	private byte[] bytes;

	public CpUTF8Info(byte[] bytes)
	{
		this.length = (short) bytes.length;
		this.bytes = bytes;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.UTF8;
	}

	public short getLength()
	{
		return length;
	}

	public byte[] getBytes()
	{
		return bytes;
	}

}
