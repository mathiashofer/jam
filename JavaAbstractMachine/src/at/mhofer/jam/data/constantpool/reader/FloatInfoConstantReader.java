package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.FloatInfoConstant;

public class FloatInfoConstantReader implements ConstantPoolInfoReader
{

	@Override
	public FloatInfoConstant readData(DataInputStream in) throws IOException
	{
		float bytes = in.readFloat();
		return new FloatInfoConstant(bytes);
	}

}
