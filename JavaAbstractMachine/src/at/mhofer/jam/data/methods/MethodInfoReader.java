package at.mhofer.jam.data.methods;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.AccessFlag;
import at.mhofer.jam.data.DataReader;
import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.CodeAttribute;
import at.mhofer.jam.data.attributes.reader.AttributeInfoReader;
import at.mhofer.jam.data.constantpool.ConstantPoolInfo;
import at.mhofer.jam.data.constantpool.ConstantPoolTag;
import at.mhofer.jam.data.constantpool.UTF8InfoConstant;

public class MethodInfoReader implements DataReader<MethodInfo>
{
	private AttributeInfoReader reader;
	
	private ConstantPoolInfo[] constantPool;
	
	public MethodInfoReader(ConstantPoolInfo[] constantPool)
	{
		this.constantPool = constantPool;
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
		CodeAttribute codeAttribute = null;
		AttributeInfo[] attributes = new AttributeInfo[attributesCount];
		for (int i = 0; i < attributesCount; i++)
		{
			AttributeInfo attribute = reader.readData(in);
			attributes[i] = attribute;
			
			//check if the current attribute is the code attribute
			ConstantPoolInfo cpInfo = constantPool[attribute.getAttributeNameIndex()];
			if (cpInfo.getTag() == ConstantPoolTag.UTF8)
			{
				UTF8InfoConstant constant = (UTF8InfoConstant) cpInfo;
				if (constant.getValue().equals("Code") && attribute instanceof CodeAttribute)
				{
					codeAttribute = (CodeAttribute) attribute;
				}
			}
		}
		
		return new MethodInfo(accessFlags, nameIndex, descriptorIndex, attributesCount, attributes, codeAttribute);
	}

}
