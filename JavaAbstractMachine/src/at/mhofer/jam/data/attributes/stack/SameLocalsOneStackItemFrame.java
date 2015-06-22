package at.mhofer.jam.data.attributes.stack;

import at.mhofer.jam.data.attributes.verification.VerificationTypeInfo;

public class SameLocalsOneStackItemFrame extends StackMapFrame
{

	private VerificationTypeInfo stack;

	public SameLocalsOneStackItemFrame(int frameType, VerificationTypeInfo stack)
	{
		super(frameType);
		this.stack = stack;
	}
	
	public VerificationTypeInfo getStack()
	{
		return stack;
	}
}
