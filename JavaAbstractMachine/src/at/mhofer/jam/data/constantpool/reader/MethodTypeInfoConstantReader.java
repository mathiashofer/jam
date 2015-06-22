package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.MethodTypeInfoConstant;

public class MethodTypeInfoConstantReader implements ConstantPoolInfoReader
{

	@Override
	public MethodTypeInfoConstant readData(DataInputStream in) throws IOException
	{
		int descriptorIndex = in.readUnsignedShort();
		return new MethodTypeInfoConstant(descriptorIndex);
	}

}
