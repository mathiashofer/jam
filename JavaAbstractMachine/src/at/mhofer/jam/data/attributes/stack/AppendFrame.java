package at.mhofer.jam.data.attributes.stack;

import at.mhofer.jam.data.attributes.verification.VerificationTypeInfo;

public class AppendFrame extends StackMapFrame
{

	private int offsetDelta;
	
	/**
	 * locals.length = typeValue - 251
	 */
	private VerificationTypeInfo[] locals;

	public AppendFrame(int frameType, int offsetDelta, VerificationTypeInfo[] locals)
	{
		super(frameType);
		this.offsetDelta = offsetDelta;
		this.locals = locals;
	}
	
	public int getOffsetDelta()
	{
		return offsetDelta;
	}
	
	public VerificationTypeInfo[] getLocals()
	{
		return locals;
	}

}
