package at.mhofer.jam.runtime.data.variables;

public abstract class Variable<T>
{
	private T value;

	public Variable(T value)
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
