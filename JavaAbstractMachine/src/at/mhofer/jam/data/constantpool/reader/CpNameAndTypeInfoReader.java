package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpNameAndTypeInfo;

public class CpNameAndTypeInfoReader implements CpInfoReader
{

	@Override
	public CpNameAndTypeInfo readInfo(DataInputStream in) throws IOException
	{
		int nameIndex = in.readUnsignedShort();
		int descriptorIndex = in.readUnsignedShort();
		return new CpNameAndTypeInfo(nameIndex, descriptorIndex);
	}

}
