package at.mhofer.jam.data.attributes.stack.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.stack.AppendFrame;
import at.mhofer.jam.data.attributes.stack.StackMapFrame;
import at.mhofer.jam.data.attributes.verification.VerificationTypeInfo;
import at.mhofer.jam.data.attributes.verification.reader.VerificationTypeInfoReader;

public class AppendFrameStrategy implements StackMapFrameReaderStrategy
{

	@Override
	public StackMapFrame readData(DataInputStream in, int frameType) throws IOException
	{
		int offsetDelta = in.readUnsignedShort();

		VerificationTypeInfoReader reader = new VerificationTypeInfoReader();
		// See spec for size description
		VerificationTypeInfo[] locals = new VerificationTypeInfo[frameType - 251];
		for (int i = 0; i < locals.length; i++)
		{
			VerificationTypeInfo local = reader.readData(in);
			locals[i] = local;
		}

		return new AppendFrame(frameType, offsetDelta, locals);
	}

}
