package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpMethodHandleInfo;

public class CpMethodHandleInfoReader implements CpInfoReader
{

	@Override
	public CpMethodHandleInfo readInfo(DataInputStream in) throws IOException
	{
		/**
		 * readByte() ist used instead of readUnsignedByte(), because
		 * referenceKind has to be a number between 1 and 9 anyway.
		 */
		byte referenceKind = in.readByte();
		
		int referenceIndex = in.readUnsignedShort();
		return new CpMethodHandleInfo(referenceKind, referenceIndex);
	}

}
