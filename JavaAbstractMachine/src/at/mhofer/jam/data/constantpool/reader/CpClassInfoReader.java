package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpClassInfo;

public class CpClassInfoReader implements CpInfoReader
{

	@Override
	public CpClassInfo readInfo(DataInputStream in) throws IOException
	{
		short nameIndex = in.readShort();
		return new CpClassInfo(nameIndex);
	}

}
