package at.mhofer.jam.data.attributes.stack.reader;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import at.mhofer.jam.data.DataReader;
import at.mhofer.jam.data.attributes.stack.StackMapFrame;
import at.mhofer.jam.data.attributes.stack.StackMapFrameType;

public class StackMapFrameReader implements DataReader<StackMapFrame>
{
	private static final Map<StackMapFrameType, StackMapFrameReaderStrategy> strategies = new HashMap<StackMapFrameType, StackMapFrameReaderStrategy>();

	static
	{
		strategies.put(StackMapFrameType.SAME_FRAME, new SameFrameStrategy());
		strategies.put(StackMapFrameType.SAME_LOCALS_1_STACK_ITEM_FRAME, new SameLocalsOneStackItemFrameStrategy());
		strategies.put(StackMapFrameType.SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED, new SameLocalsOneStackItemFrameExtendedStrategy());
		strategies.put(StackMapFrameType.CHOP_FRAME, new ChopFrameStrategy());
		strategies.put(StackMapFrameType.SAME_FRAME_EXTENDED, new SameFrameExtendedStrategy());
		strategies.put(StackMapFrameType.APPEND_FRAME, new AppendFrameStrategy());
		strategies.put(StackMapFrameType.FULL_FRAME, new FullFrameStrategy());
	}

	@Override
	public StackMapFrame readData(DataInputStream in) throws IOException
	{
		int frameType = in.readUnsignedByte();

		StackMapFrameType type = StackMapFrameType.fromValue(frameType);
		StackMapFrameReaderStrategy strategy = strategies.get(type);

		StackMapFrame frame = null;
		if (strategy == null)
		{
			LogManager.getLogger().warn("Frame Type not supported: {}", type);
		}
		else
		{
			frame = strategy.readData(in, frameType);
		}

		return frame;
	}

}
