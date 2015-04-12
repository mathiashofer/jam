package at.mhofer.jam.data.attributes;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.DataReader;

public class AttributeInfoReader implements DataReader<AttributeInfo>
{

	@Override
	public AttributeInfo readData(DataInputStream in) throws IOException
	{
		int attributeNameIndex = in.readUnsignedShort();
		int attributeLength = in.readInt();
		byte[] info = new byte[attributeLength];
		in.read(info, 0, info.length);
		return new AttributeInfo(attributeNameIndex, attributeLength, info);
	}

}
