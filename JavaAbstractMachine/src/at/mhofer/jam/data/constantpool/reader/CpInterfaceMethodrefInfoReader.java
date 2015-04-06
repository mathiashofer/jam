package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpInterfaceMethodrefInfo;

public class CpInterfaceMethodrefInfoReader implements CpReader
{

	@Override
	public CpInterfaceMethodrefInfo readInfo(DataInputStream in) throws IOException
	{
		short classIndex = in.readShort();
		short nameAndTypeIndex = in.readShort();
		return new CpInterfaceMethodrefInfo(classIndex, nameAndTypeIndex);
	}

}
