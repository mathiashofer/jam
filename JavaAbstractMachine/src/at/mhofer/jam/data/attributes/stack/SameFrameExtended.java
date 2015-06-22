package at.mhofer.jam.data.attributes.stack;

public class SameFrameExtended extends StackMapFrame
{

	private int offsetDelta;

	public SameFrameExtended(int frameType, int offsetDelta)
	{
		super(frameType);
		this.offsetDelta = offsetDelta;
	}

	public int getOffsetDelta()
	{
		return offsetDelta;
	}

}
