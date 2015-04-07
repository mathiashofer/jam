package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpInvokeDynamicInfo;


public class CpInvokeDynamicInfoReader implements CpInfoReader
{

	@Override
	public CpInvokeDynamicInfo readInfo(DataInputStream in) throws IOException
	{
		short bootstrapMethodAttrIndex = in.readShort();
		short nameAndTypeIndex = in.readShort();
		return new CpInvokeDynamicInfo(bootstrapMethodAttrIndex, nameAndTypeIndex);
	}

}
