package at.mhofer.jam.runtime.data;

public class Reference implements DataType
{

	private Integer value;

	public Reference(Integer value)
	{
		this.value = value;
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
