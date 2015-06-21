package at.mhofer.jam.data.constantpool;

/**
 * Deviates from the specification, where the high and low bytes are stored
 * separately.
 * 
 * @author Mathias
 *
 */
public class LongInfoConstant implements ConstantPoolInfo
{

	private long bytes;

	public LongInfoConstant(long bytes)
	{
		this.bytes = bytes;
	}

	@Override
	public ConstantPoolTag getTag()
	{
		return ConstantPoolTag.LONG;
	}
	
	public long getBytes()
	{
		return bytes;
	}

}
