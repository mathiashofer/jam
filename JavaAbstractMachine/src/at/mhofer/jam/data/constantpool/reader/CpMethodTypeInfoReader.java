package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpMethodTypeInfo;

public class CpMethodTypeInfoReader implements CpInfoReader
{

	@Override
	public CpMethodTypeInfo readData(DataInputStream in) throws IOException
	{
		int descriptorIndex = in.readUnsignedShort();
		return new CpMethodTypeInfo(descriptorIndex);
	}

}
