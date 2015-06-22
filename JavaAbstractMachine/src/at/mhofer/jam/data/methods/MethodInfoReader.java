package at.mhofer.jam.data.methods;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.AccessFlag;
import at.mhofer.jam.data.DataReader;
import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.reader.AttributeInfoReader;
import at.mhofer.jam.data.constantpool.ConstantPoolInfo;

public class MethodInfoReader implements DataReader<MethodInfo>
{
	private AttributeInfoReader reader;
	
	public MethodInfoReader(ConstantPoolInfo[] constantPool)
	{
		this.reader = new AttributeInfoReader(constantPool);
	}	

	@Override
	public MethodInfo readData(DataInputStream in) throws IOException
	{
		short flagBytes = in.readShort();
		AccessFlag[] accessFlags = AccessFlag.fromBytes(flagBytes);
		int nameIndex = in.readUnsignedShort();
		int descriptorIndex = in.readUnsignedShort();
		int attributesCount = in.readUnsignedShort();
		AttributeInfo[] attributes = new AttributeInfo[attributesCount];
		for (int i = 0; i < attributesCount; i++)
		{
			AttributeInfo attribute = reader.readData(in);
			attributes[i] = attribute;
		}
		
		return new MethodInfo(accessFlags, nameIndex, descriptorIndex, attributesCount, attributes);
	}

}
