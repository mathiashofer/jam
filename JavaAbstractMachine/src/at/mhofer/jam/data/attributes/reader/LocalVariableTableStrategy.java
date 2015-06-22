package at.mhofer.jam.data.attributes.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.LocalVariableTableAttribute;
import at.mhofer.jam.data.attributes.LocalVariableTableEntry;

public class LocalVariableTableStrategy implements AttributeInfoReaderStrategy
{
	@Override
	public AttributeInfo readData(DataInputStream in, int attributeNameIndex, long attributeLength)
			throws IOException
	{
		int localVariableTableLength = in.readUnsignedShort();
		LocalVariableTableEntry[] localVariableTable = new LocalVariableTableEntry[localVariableTableLength];
		
		for (int i = 0; i < localVariableTableLength; i++)
		{
			LocalVariableTableEntry entry = readLocalVariableTableEntry(in);
			localVariableTable[i] = entry;
		}
		
		return new LocalVariableTableAttribute(attributeNameIndex, attributeLength, localVariableTableLength, localVariableTable);
	}

	private LocalVariableTableEntry readLocalVariableTableEntry(DataInputStream in) throws IOException
	{
		int startPC = in.readUnsignedShort();
		int length = in.readUnsignedShort();
		int nameIndex = in.readUnsignedShort();
		int descriptorIndex = in.readUnsignedShort();
		int index = in.readUnsignedShort();
		return new LocalVariableTableEntry(startPC, length, nameIndex, descriptorIndex, index);
	}
}
