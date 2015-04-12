package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpMethodrefInfo;

public class CpMethodRefInfoReader implements CpInfoReader
{

	@Override
	public CpMethodrefInfo readData(DataInputStream in) throws IOException
	{
		int classIndex = in.readUnsignedShort();
		int nameAndTypeIndex = in.readUnsignedShort();
		return new CpMethodrefInfo(classIndex, nameAndTypeIndex);
	}

}
