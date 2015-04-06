package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpNameAndTypeInfo;

public class CpNameAndTypeInfoReader implements CpReader
{

	@Override
	public CpNameAndTypeInfo readInfo(DataInputStream in) throws IOException
	{
		short nameIndex = in.readShort();
		short descriptorIndex = in.readShort();
		return new CpNameAndTypeInfo(nameIndex, descriptorIndex);
	}

}
