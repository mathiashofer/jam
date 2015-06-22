package at.mhofer.jam.data.attributes.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.LineNumberTableAttribute;
import at.mhofer.jam.data.attributes.LineNumberTableEntry;

public class LineNumberTableStrategy implements AttributeInfoReaderStrategy
{

	@Override
	public AttributeInfo readData(DataInputStream in, int attributeNameIndex, long attributeLength)
			throws IOException
	{
		int lineNumberTableLength = in.readUnsignedShort();
		
		LineNumberTableEntry[] lineNumberTable = new LineNumberTableEntry[lineNumberTableLength];
		for (int i = 0; i < lineNumberTableLength; i++)
		{
			LineNumberTableEntry entry = readLineNumberTableEntry(in);
			lineNumberTable[i] = entry;
		}
		
		return new LineNumberTableAttribute(attributeNameIndex, attributeLength,
				lineNumberTableLength, lineNumberTable);
	}

	private LineNumberTableEntry readLineNumberTableEntry(DataInputStream in) throws IOException
	{
		int startPC = in.readUnsignedShort();
		int lineNumber = in.readUnsignedShort();
		return new LineNumberTableEntry(startPC, lineNumber);
	}
}
