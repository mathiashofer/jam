package at.mhofer.jam.data.attributes.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.DataSource;
import at.mhofer.jam.data.U4Array;
import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.CodeAttribute;
import at.mhofer.jam.data.attributes.ExceptionIndexTableEntry;
import at.mhofer.jam.data.constantpool.ConstantPoolInfo;

public class CodeStrategy implements AttributeInfoReaderStrategy
{
	private DataSource<ConstantPoolInfo[]> constantPoolSource;

	public CodeStrategy(DataSource<ConstantPoolInfo[]> constantPoolSource)
	{
		this.constantPoolSource = constantPoolSource;
	}

	@Override
	public AttributeInfo readData(DataInputStream in, int attributeNameIndex, long attributeLength)
			throws IOException
	{
		int maxStack = in.readUnsignedShort();
		int maxLocals = in.readUnsignedShort();
		long codeLength = in.readInt() & 0xFFFFFFFFL;
		U4Array<Byte> code = new U4Array<Byte>(codeLength);

		//TODO: implement buffer
		for (int i = 0; i < codeLength; i++)
		{
			byte b = in.readByte();
			code.add(i, b);
		}

		// read exception table
		int exceptionTableLength = in.readUnsignedShort();
		ExceptionIndexTableEntry[] exceptionTable = new ExceptionIndexTableEntry[exceptionTableLength];
		for (int i = 0; i < exceptionTableLength; i++)
		{
			ExceptionIndexTableEntry entry = readExceptionIndexTableEntry(in);
			exceptionTable[i] = entry;
		}

		// read attributes
		int attributesCount = in.readUnsignedShort();

		ConstantPoolInfo[] constantPool = constantPoolSource.getValue();
		AttributeInfoReader reader = new AttributeInfoReader(constantPool);
		AttributeInfo[] attributes = new AttributeInfo[attributesCount];
		for (int i = 0; i < attributesCount; i++)
		{
			AttributeInfo attribute = reader.readData(in);
			attributes[i] = attribute;
		}

		return new CodeAttribute(attributeNameIndex, attributeLength, maxStack, maxLocals,
				codeLength, code, exceptionTableLength, exceptionTable, attributesCount, attributes);
	}

	private ExceptionIndexTableEntry readExceptionIndexTableEntry(DataInputStream in)
			throws IOException
	{
		int startPC = in.readUnsignedShort();
		int endPC = in.readUnsignedShort();
		int handlerPC = in.readUnsignedShort();
		int catchType = in.readUnsignedShort();
		return new ExceptionIndexTableEntry(startPC, endPC, handlerPC, catchType);
	}

}
