package at.mhofer.jam.data.attributes.stack;

public class ChopFrame extends StackMapFrame
{

	private int offsetDelta;

	public ChopFrame(int frameType, int offsetDelta)
	{
		super(frameType);
		this.offsetDelta = offsetDelta;
	}
	
	public int getOffsetDelta()
	{
		return offsetDelta;
	}
	
}
