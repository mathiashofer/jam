package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpFieldrefInfo;

public class CpFieldRefInfoReader implements CpInfoReader
{

	@Override
	public CpFieldrefInfo readData(DataInputStream in) throws IOException
	{
		int classIndex = in.readUnsignedShort();
		int nameAndTypeIndex = in.readUnsignedShort();
		return new CpFieldrefInfo(classIndex, nameAndTypeIndex);
	}

}
