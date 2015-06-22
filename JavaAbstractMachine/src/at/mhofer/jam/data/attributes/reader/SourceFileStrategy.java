package at.mhofer.jam.data.attributes.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.SourceFileAttribute;

public class SourceFileStrategy implements AttributeInfoReaderStrategy
{

	@Override
	public AttributeInfo readData(DataInputStream in, int attributeNameIndex, long attributeLength)
			throws IOException
	{
		int sourcefileIndex = in.readUnsignedShort();
		return new SourceFileAttribute(attributeNameIndex, attributeLength, sourcefileIndex);
	}

}
