package at.mhofer.jam.data.attributes.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.AttributeInfo;

public interface AttributeInfoReaderStrategy
{
	
	public AttributeInfo readData(DataInputStream in, int attributeNameIndex, long attributeLength) throws IOException;

}
