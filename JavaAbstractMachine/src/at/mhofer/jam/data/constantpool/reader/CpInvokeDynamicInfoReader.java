package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpInvokeDynamicInfo;


public class CpInvokeDynamicInfoReader implements CpInfoReader
{

	@Override
	public CpInvokeDynamicInfo readData(DataInputStream in) throws IOException
	{
		int bootstrapMethodAttrIndex = in.readUnsignedShort();
		int nameAndTypeIndex = in.readUnsignedShort();
		return new CpInvokeDynamicInfo(bootstrapMethodAttrIndex, nameAndTypeIndex);
	}

}
