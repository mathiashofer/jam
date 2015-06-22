package at.mhofer.jam.data.attributes.stack.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.stack.FullFrame;
import at.mhofer.jam.data.attributes.stack.StackMapFrame;
import at.mhofer.jam.data.attributes.verification.VerificationTypeInfo;
import at.mhofer.jam.data.attributes.verification.reader.VerificationTypeInfoReader;

public class FullFrameStrategy implements StackMapFrameReaderStrategy
{

	@Override
	public StackMapFrame readData(DataInputStream in, int frameType) throws IOException
	{
		int offsetDelta = in.readUnsignedShort();
		int numberOfLocals = in.readUnsignedShort();

		VerificationTypeInfoReader reader = new VerificationTypeInfoReader();
		VerificationTypeInfo[] locals = new VerificationTypeInfo[numberOfLocals];
		for (int i = 0; i < numberOfLocals; i++)
		{
			VerificationTypeInfo local = reader.readData(in);
			locals[i] = local;
		}

		int numberOfStackItems = in.readUnsignedShort();
		VerificationTypeInfo[] stack = new VerificationTypeInfo[numberOfStackItems];
		for (int i = 0; i < numberOfStackItems; i++)
		{
			VerificationTypeInfo item = reader.readData(in);
			stack[i] = item;
		}

		return new FullFrame(frameType, offsetDelta, numberOfLocals, stack, numberOfStackItems,
				stack);
	}

}
