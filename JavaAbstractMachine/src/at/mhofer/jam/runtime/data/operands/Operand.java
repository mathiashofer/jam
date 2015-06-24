package at.mhofer.jam.runtime.data.operands;

public abstract class Operand<T>
{
	private T value;

	public Operand(T value)
	{
		this.value = value;
	}

	public T getValue()
	{
		return value;
	}

	public void setValue(T value)
	{
		this.value = value;
	}

}
