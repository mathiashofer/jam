package at.mhofer.jam.data.attributes.stack.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.stack.SameLocalsOneStackItemFrameExtended;
import at.mhofer.jam.data.attributes.stack.StackMapFrame;
import at.mhofer.jam.data.attributes.verification.VerificationTypeInfo;
import at.mhofer.jam.data.attributes.verification.reader.VerificationTypeInfoReader;

public class SameLocalsOneStackItemFrameExtendedStrategy implements StackMapFrameReaderStrategy
{

	@Override
	public StackMapFrame readData(DataInputStream in, int frameType) throws IOException
	{
		int offsetDelta = in.readUnsignedShort();
		
		VerificationTypeInfoReader reader = new VerificationTypeInfoReader();
		VerificationTypeInfo stack = reader.readData(in);
		
		return new SameLocalsOneStackItemFrameExtended(frameType, offsetDelta, stack);
	}

}
