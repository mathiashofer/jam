package at.mhofer.jam.data.attributes.stack.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.stack.ChopFrame;
import at.mhofer.jam.data.attributes.stack.StackMapFrame;

public class ChopFrameStrategy implements StackMapFrameReaderStrategy
{

	@Override
	public StackMapFrame readData(DataInputStream in, int frameType) throws IOException
	{
		int offsetDelta = in.readUnsignedShort();
		return new ChopFrame(frameType, offsetDelta);
	}

}
