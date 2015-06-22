package at.mhofer.jam.data;

/**
 * This wrapper is necessary sometimes, especially if some information is
 * currently not available, but gets injected later into this wrapper.
 * 
 * @author Mathias
 *
 * @param <T>
 */
public class DataSource<T>
{
	private T value;

	public DataSource()
	{
	}

	public DataSource(T value)
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
