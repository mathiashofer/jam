package at.mhofer.jam.data.constantpool;

/**
 * Deviates from the specification, where the high and low bytes are stored
 * separately.
 * 
 * @author Mathias
 *
 */
public class CpLongInfo implements CpInfo
{

	private long bytes;

	public CpLongInfo(long bytes)
	{
		this.bytes = bytes;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.LONG;
	}
	
	public long getBytes()
	{
		return bytes;
	}

}
