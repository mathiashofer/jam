package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpFloatInfo;

public class CpFloatInfoReader implements CpInfoReader
{

	@Override
	public CpFloatInfo readData(DataInputStream in) throws IOException
	{
		float bytes = in.readFloat();
		return new CpFloatInfo(bytes);
	}

}
