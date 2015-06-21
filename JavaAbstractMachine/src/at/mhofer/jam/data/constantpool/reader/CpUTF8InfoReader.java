package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.UTF8InfoConstant;

public class CpUTF8InfoReader implements CpInfoReader
{

	@Override
	public UTF8InfoConstant readData(DataInputStream in) throws IOException
	{
		int length = in.readUnsignedShort();
		byte[] bytes = new byte[length];
		in.readFully(bytes);
		return new UTF8InfoConstant(bytes);
	}

}
