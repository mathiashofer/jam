package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpUTF8Info;

public class CpUTF8InfoReader implements CpInfoReader
{

	@Override
	public CpUTF8Info readData(DataInputStream in) throws IOException
	{
		int length = in.readUnsignedShort();
		byte[] bytes = new byte[length];
		in.readFully(bytes);
		return new CpUTF8Info(bytes);
	}

}
