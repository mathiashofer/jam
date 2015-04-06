package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpMethodrefInfo;

public class CpMethodRefInfoReader implements CpReader
{

	@Override
	public CpMethodrefInfo readInfo(DataInputStream in) throws IOException
	{
		short classIndex = in.readShort();
		short nameAndTypeIndex = in.readShort();
		return new CpMethodrefInfo(classIndex, nameAndTypeIndex);
	}

}
