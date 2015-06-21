package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.NameAndTypeInfoConstant;

public class CpNameAndTypeInfoReader implements CpInfoReader
{

	@Override
	public NameAndTypeInfoConstant readData(DataInputStream in) throws IOException
	{
		int nameIndex = in.readUnsignedShort();
		int descriptorIndex = in.readUnsignedShort();
		return new NameAndTypeInfoConstant(nameIndex, descriptorIndex);
	}

}
