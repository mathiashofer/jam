package at.mhofer.jam.data.constantpool;

public class DoubleInfoConstant implements ConstantPoolInfo
{

	/**
	 * double is used, because java itself should interpret the bytes as double
	 */
	private double bytes;
	
	public DoubleInfoConstant(double bytes)
	{
		this.bytes = bytes;
	}
	
	@Override
	public ConstantPoolTag getTag()
	{
		return ConstantPoolTag.DOUBLE;
	}
	
	public double getBytes()
	{
		return bytes;
	}
}
