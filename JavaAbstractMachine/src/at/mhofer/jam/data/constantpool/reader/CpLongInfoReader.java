package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.LongInfoConstant;

public class CpLongInfoReader implements CpInfoReader
{

	@Override
	public LongInfoConstant readData(DataInputStream in) throws IOException
	{
		long bytes = in.readLong();
		return new LongInfoConstant(bytes);
	}

}
