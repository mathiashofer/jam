package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpDoubleInfo;

public class CpDoubleInfoReader implements CpReader
{

	@Override
	public CpDoubleInfo readInfo(DataInputStream in) throws IOException
	{
		double bytes = in.readDouble();
		return new CpDoubleInfo(bytes);
	}

}