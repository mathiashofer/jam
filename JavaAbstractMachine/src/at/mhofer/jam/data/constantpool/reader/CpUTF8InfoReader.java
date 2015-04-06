package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpUTF8Info;

public class CpUTF8InfoReader implements CpReader
{

	@Override
	public CpUTF8Info readInfo(DataInputStream in) throws IOException
	{
		short length = in.readShort();
		byte[] bytes = new byte[length];
		in.readFully(bytes);
		return new CpUTF8Info(bytes);
	}

}
