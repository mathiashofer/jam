package at.mhofer.jam.data.constantpool;

public class IntegerInfoConstant implements ConstantPoolInfo
{
	
	/**
	 * The bytes item of the CONSTANT_Integer_info structure represents the
	 * value of the int constant. The bytes of the value are stored in
	 * big-endian (high byte first) order.
	 */
	private int bytes;

	public IntegerInfoConstant(int bytes)
	{
		this.bytes = bytes;
	}

	@Override
	public ConstantPoolTag getTag()
	{
		return ConstantPoolTag.INTEGER;
	}

	public int getBytes()
	{
		return bytes;
	}

}
