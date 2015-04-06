package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpMethodHandleInfo;

public class CpMethodHandleInfoReader implements CpReader
{

	@Override
	public CpMethodHandleInfo readInfo(DataInputStream in) throws IOException
	{
		byte referenceKind = in.readByte();
		short referenceIndex = in.readShort();
		return new CpMethodHandleInfo(referenceKind, referenceIndex);
	}

}
