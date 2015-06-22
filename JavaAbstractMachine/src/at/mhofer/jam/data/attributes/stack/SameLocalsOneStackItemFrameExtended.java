package at.mhofer.jam.data.attributes.stack;

import at.mhofer.jam.data.attributes.verification.VerificationTypeInfo;

public class SameLocalsOneStackItemFrameExtended extends StackMapFrame
{

	private int offsetDelta;
	
	private VerificationTypeInfo stack;

	public SameLocalsOneStackItemFrameExtended(int frameType, int offsetDelta,
			VerificationTypeInfo stack)
	{
		super(frameType);
		this.offsetDelta = offsetDelta;
		this.stack = stack;
	}
	
	public int getOffsetDelta()
	{
		return offsetDelta;
	}
	
	public VerificationTypeInfo getStack()
	{
		return stack;
	}
	
}
