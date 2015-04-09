package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpInterfaceMethodrefInfo;

public class CpInterfaceMethodrefInfoReader implements CpInfoReader
{

	@Override
	public CpInterfaceMethodrefInfo readInfo(DataInputStream in) throws IOException
	{
		int classIndex = in.readUnsignedShort();
		int nameAndTypeIndex = in.readUnsignedShort();
		return new CpInterfaceMethodrefInfo(classIndex, nameAndTypeIndex);
	}

}
