package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.IntegerInfoConstant;

public class CpIntegerInfoReader implements CpInfoReader
{

	@Override
	public IntegerInfoConstant readData(DataInputStream in) throws IOException
	{
		int bytes = in.readInt();
		return new IntegerInfoConstant(bytes);
	}

}
