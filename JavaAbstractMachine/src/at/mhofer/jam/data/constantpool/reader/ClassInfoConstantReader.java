package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.ClassInfoConstant;

public class ClassInfoConstantReader implements ConstantPoolInfoReader
{

	@Override
	public ClassInfoConstant readData(DataInputStream in) throws IOException
	{
		int nameIndex = in.readUnsignedShort();
		return new ClassInfoConstant(nameIndex);
	}

}
