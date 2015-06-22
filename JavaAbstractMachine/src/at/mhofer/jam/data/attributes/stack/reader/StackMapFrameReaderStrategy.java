package at.mhofer.jam.data.attributes.stack.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.attributes.stack.StackMapFrame;

public interface StackMapFrameReaderStrategy
{

	public StackMapFrame readData(DataInputStream in, int frameType) throws IOException;

	
}
