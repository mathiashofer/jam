package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpStringInfo;

public class CpStringInfoReader implements CpReader
{

	@Override
	public CpStringInfo readInfo(DataInputStream in) throws IOException
	{
		short stringIndex = in.readShort();
		return new CpStringInfo(stringIndex);
	}

}