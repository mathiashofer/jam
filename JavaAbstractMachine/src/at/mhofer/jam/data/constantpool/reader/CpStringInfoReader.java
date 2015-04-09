package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpStringInfo;

public class CpStringInfoReader implements CpInfoReader
{

	@Override
	public CpStringInfo readInfo(DataInputStream in) throws IOException
	{
		int stringIndex = in.readUnsignedShort();
		return new CpStringInfo(stringIndex);
	}

}
