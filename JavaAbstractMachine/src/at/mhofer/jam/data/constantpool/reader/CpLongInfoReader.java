package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpLongInfo;

public class CpLongInfoReader implements CpInfoReader
{

	@Override
	public CpLongInfo readInfo(DataInputStream in) throws IOException
	{
		long bytes = in.readLong();
		return new CpLongInfo(bytes);
	}

}
