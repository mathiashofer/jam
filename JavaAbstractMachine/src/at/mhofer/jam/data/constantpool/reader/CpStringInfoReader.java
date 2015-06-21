package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.StringInfoConstant;

public class CpStringInfoReader implements CpInfoReader
{

	@Override
	public StringInfoConstant readData(DataInputStream in) throws IOException
	{
		int stringIndex = in.readUnsignedShort();
		return new StringInfoConstant(stringIndex);
	}

}
