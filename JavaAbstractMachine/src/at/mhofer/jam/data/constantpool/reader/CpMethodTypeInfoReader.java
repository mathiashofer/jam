package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpMethodTypeInfo;

public class CpMethodTypeInfoReader implements CpInfoReader
{

	@Override
	public CpMethodTypeInfo readInfo(DataInputStream in) throws IOException
	{
		short descriptorIndex = in.readShort();
		return new CpMethodTypeInfo(descriptorIndex);
	}

}
