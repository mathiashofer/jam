package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpFieldrefInfo;

public class CpFieldRefInfoReader implements CpReader
{

	@Override
	public CpFieldrefInfo readInfo(DataInputStream in) throws IOException
	{
		short classIndex = in.readShort();
		short nameAndTypeIndex = in.readShort();
		return new CpFieldrefInfo(classIndex, nameAndTypeIndex);
	}

}
