package at.mhofer.jam.runtime.data;

public class Reference implements DataType
{
	public static final Reference NULL = new Reference(null);

	private Integer value;

	public Reference(Integer value)
	{
		this.value = value;
	}
	
	public boolean isNull()
	{
		return value == null;
	}

	@Override
	public Integer getValue()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return "Reference [value=" + value + "]";
	}

}
