package at.mhofer.jam.data.attributes.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.StackMapTableAttribute;
import at.mhofer.jam.data.attributes.stack.StackMapFrame;
import at.mhofer.jam.data.attributes.stack.reader.StackMapFrameReader;

public class StackMapTableStrategy implements AttributeInfoReaderStrategy
{

	@Override
	public AttributeInfo readData(DataInputStream in, int attributeNameIndex, long attributeLength)
			throws IOException
	{
		int numberOfEntries = in.readUnsignedShort();
		
		StackMapFrameReader reader = new StackMapFrameReader();
		StackMapFrame[] entries = new StackMapFrame[numberOfEntries];
		for (int i = 0; i < numberOfEntries; i++)
		{
			StackMapFrame frame = reader.readData(in);
			entries[i] = frame;
		}
		
		return new StackMapTableAttribute(attributeNameIndex, attributeLength, numberOfEntries, entries);
	}

}
