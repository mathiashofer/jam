package at.mhofer.jam.data.attributes.stack.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.stack.SameFrame;
import at.mhofer.jam.data.attributes.stack.StackMapFrame;

public class SameFrameStrategy implements StackMapFrameReaderStrategy
{

	@Override
	public StackMapFrame readData(DataInputStream in, int frameType) throws IOException
	{
		return new SameFrame(frameType);
	}

}
