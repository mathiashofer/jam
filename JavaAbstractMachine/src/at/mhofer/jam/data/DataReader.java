package at.mhofer.jam.data;

import java.io.DataInputStream;
import java.io.IOException;

public interface DataReader<T>
{
	
	public T readData(DataInputStream in) throws IOException;

}
