package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.DoubleInfoConstant;

public class CpDoubleInfoReader implements CpInfoReader
{

	@Override
	public DoubleInfoConstant readData(DataInputStream in) throws IOException
	{
		double bytes = in.readDouble();
		return new DoubleInfoConstant(bytes);
	}

}
