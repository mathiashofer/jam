package at.mhofer.jam.data.attributes.verification;

public enum VerificationTypeTag
{
	TOP(0),
	INTEGER(1),
	FLOAT(2),
	NULL(5),
	UNINITIALIZED_THIS(6),
	OBJECT(7),
	UNINITIALIZED(8),
	LONG(4),
	DOUBLE(3);
	
	private final int value;

	private VerificationTypeTag(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
}
