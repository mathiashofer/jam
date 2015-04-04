package at.mhofer.jam.data.constantpool;

public class CpIntegerInfo implements CpInfo
{
	
	/**
	 * The bytes item of the CONSTANT_Integer_info structure represents the
	 * value of the int constant. The bytes of the value are stored in
	 * big-endian (high byte first) order.
	 */
	private int bytes;

	public CpIntegerInfo(int bytes)
	{
		this.bytes = bytes;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.INTEGER;
	}

	public int getBytes()
	{
		return bytes;
	}

}
