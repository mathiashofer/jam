package at.mhofer.jam.data.constantpool;

public class CpDoubleInfo implements CpInfo
{

	/**
	 * double is used, because java itself should interpret the bytes as double
	 */
	private double bytes;
	
	public CpDoubleInfo(double bytes)
	{
		this.bytes = bytes;
	}
	
	@Override
	public CpTag getTag()
	{
		return CpTag.DOUBLE;
	}
	
	public double getBytes()
	{
		return bytes;
	}
}
