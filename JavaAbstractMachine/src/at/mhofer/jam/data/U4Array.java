package at.mhofer.jam.data;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Mathias
 *
 * @param <T>
 */
public class U4Array<T> implements Iterable<T>
{
	/**
	 * 2^31 - 3
	 */
	private static int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 2;

	/**
	 * Used for indices between 0 (inclusive) and Integer.MAX_VALUE - 2
	 * (exclusive)
	 */
	private ArrayList<T> array1;

	/**
	 * Used for indices between Integer.MAX_VALUE - 2 (inclusive) and
	 * Integer.MAX_VALUE * 2 - 4 (exclusive).
	 */
	private ArrayList<T> array2;

	/**
	 * Used for indices between Integer.MAX_VALUE * 2 - 4 (inclusive) and
	 * Integer.MAX_VALUE * 2 + 2 (exclusive).
	 */
	private ArrayList<T> array3;

	private long length;

	/**
	 * The length is interpreted as an unsigned integer.
	 * 
	 * @param length
	 */
	public U4Array(long length)
	{
		if (length < 0)
		{
			throw new IllegalArgumentException("length must not be less than 0");
		}
		else if (length > 2 * ((long) Integer.MAX_VALUE + 1))
		{
			throw new IllegalArgumentException("length must not be bigger than 2^32");
		}

		this.length = length;
		if (length < MAX_ARRAY_LENGTH)
		{
			this.array1 = new ArrayList<T>((int) length);
		}
		else if (length >= ((long) MAX_ARRAY_LENGTH) * 2)
		{
			this.array1 = new ArrayList<T>(MAX_ARRAY_LENGTH);
			this.array2 = new ArrayList<T>(MAX_ARRAY_LENGTH);
			// max length = 6
			this.array3 = new ArrayList<T>((int) (length - (2 * MAX_ARRAY_LENGTH)));
		}
		else if (length >= MAX_ARRAY_LENGTH)
		{
			this.array1 = new ArrayList<T>(MAX_ARRAY_LENGTH);
			this.array2 = new ArrayList<T>((int) (length - (MAX_ARRAY_LENGTH)));
		}
	}

	/**
	 * @param index
	 *            interpreted as unsigned int, and must therfore not contain
	 *            values bigger than 2^32
	 * @return
	 */
	public T get(long index)
	{
		T elem = null;
		if (index < MAX_ARRAY_LENGTH)
		{
			elem = this.array1.get((int) index);
		}
		else if (index >= ((long) MAX_ARRAY_LENGTH) * 2)
		{
			elem = this.array3.get((int) (index - (2 * MAX_ARRAY_LENGTH)));
		}
		else if (index >= MAX_ARRAY_LENGTH)
		{
			elem = this.array2.get((int) (index - MAX_ARRAY_LENGTH));
		}
		return elem;
	}
	
	public void add(long index, T elem)
	{
		if (index < MAX_ARRAY_LENGTH)
		{
			this.array1.add((int) index, elem);
		}
		else if (index >= ((long) MAX_ARRAY_LENGTH) * 2)
		{
			this.array3.add((int) (index - (2 * MAX_ARRAY_LENGTH)), elem);
		}
		else if (index >= MAX_ARRAY_LENGTH)
		{
			this.array2.add((int) (index - MAX_ARRAY_LENGTH), elem);
		}
	}

	/**
	 * Replaces the element on the given index, make sure there is some element
	 * which can be replaced.
	 * 
	 * @param index
	 * @param elem
	 */
	public void set(long index, T elem)
	{
		if (index < MAX_ARRAY_LENGTH)
		{
			this.array1.set((int) index, elem);
		}
		else if (index >= ((long) MAX_ARRAY_LENGTH) * 2)
		{
			System.out.println("Set array3: " + (int) (index - (2 * MAX_ARRAY_LENGTH)));
			this.array3.set((int) (index - (2 * MAX_ARRAY_LENGTH)), elem);
		}
		else if (index >= MAX_ARRAY_LENGTH)
		{
			System.out.println("Set array2: " + (int) (index - MAX_ARRAY_LENGTH));
			this.array2.set((int) (index - MAX_ARRAY_LENGTH), elem);
		}
	}
	
	public long getLength()
	{
		return length;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new U4ArrayIterator();
	}

	private class U4ArrayIterator implements Iterator<T>
	{
		private long currentIndex = 0;

		@Override
		public boolean hasNext()
		{
			return currentIndex < length;
		}

		@Override
		public T next()
		{
			return get(currentIndex);
		}
	}
}
