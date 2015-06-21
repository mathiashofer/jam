package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.InterfaceMethodrefInfoConstant;

public class CpInterfaceMethodrefInfoReader implements CpInfoReader
{

	@Override
	public InterfaceMethodrefInfoConstant readData(DataInputStream in) throws IOException
	{
		int classIndex = in.readUnsignedShort();
		int nameAndTypeIndex = in.readUnsignedShort();
		return new InterfaceMethodrefInfoConstant(classIndex, nameAndTypeIndex);
	}

}
