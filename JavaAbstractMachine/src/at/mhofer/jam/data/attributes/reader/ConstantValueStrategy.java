package at.mhofer.jam.data.attributes.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.ConstantValueAttribute;

public class ConstantValueStrategy implements AttributeInfoReaderStrategy
{

	@Override
	public AttributeInfo readData(DataInputStream in, int attributeNameIndex, long attributeLength)
			throws IOException
	{
		/*
		 * The value of the attribute_length item of a ConstantValue_attribute
		 * structure must be two.
		 */
		if (attributeLength != 2)
		{
			throw new IOException("attributeLength != 2");
		}
		
		int constantValueIndex = in.readUnsignedShort();

		return new ConstantValueAttribute(attributeNameIndex, attributeLength, constantValueIndex);
	}

}
