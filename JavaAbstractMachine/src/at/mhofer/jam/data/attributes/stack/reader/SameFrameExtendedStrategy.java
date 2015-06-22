package at.mhofer.jam.data.attributes.stack.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.stack.SameFrameExtended;
import at.mhofer.jam.data.attributes.stack.StackMapFrame;

public class SameFrameExtendedStrategy implements StackMapFrameReaderStrategy
{

	@Override
	public StackMapFrame readData(DataInputStream in, int frameType) throws IOException
	{
		int offsetDelta = in.readUnsignedShort();
		return new SameFrameExtended(frameType, offsetDelta);
	}

}
