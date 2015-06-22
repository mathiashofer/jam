package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.InvokeDynamicInfoConstant;


public class InvokeDynamicInfoConstantReader implements ConstantPoolInfoReader
{

	@Override
	public InvokeDynamicInfoConstant readData(DataInputStream in) throws IOException
	{
		int bootstrapMethodAttrIndex = in.readUnsignedShort();
		int nameAndTypeIndex = in.readUnsignedShort();
		return new InvokeDynamicInfoConstant(bootstrapMethodAttrIndex, nameAndTypeIndex);
	}

}
