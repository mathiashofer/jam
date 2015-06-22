package at.mhofer.jam.data.attributes.stack;

import at.mhofer.jam.data.attributes.verification.VerificationTypeInfo;

public class FullFrame extends StackMapFrame
{

	private int offsetDelta;
	
	private int numberOfLocals;
	
	private VerificationTypeInfo[] locals;
	
	private int numberOfStackItems;
	
	private VerificationTypeInfo[] stack;

	public FullFrame(int frameType, int offsetDelta, int numberOfLocals,
			VerificationTypeInfo[] locals, int numberOfStackItems, VerificationTypeInfo[] stack)
	{
		super(frameType);
		this.offsetDelta = offsetDelta;
		this.numberOfLocals = numberOfLocals;
		this.locals = locals;
		this.numberOfStackItems = numberOfStackItems;
		this.stack = stack;
	}

	public int getOffsetDelta()
	{
		return offsetDelta;
	}

	public int getNumberOfLocals()
	{
		return numberOfLocals;
	}

	public VerificationTypeInfo[] getLocals()
	{
		return locals;
	}

	public int getNumberOfStackItems()
	{
		return numberOfStackItems;
	}

	public VerificationTypeInfo[] getStack()
	{
		return stack;
	}

}
