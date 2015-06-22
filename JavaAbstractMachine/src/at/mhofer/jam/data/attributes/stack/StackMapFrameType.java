package at.mhofer.jam.data.attributes.stack;

public enum StackMapFrameType
{
	SAME_FRAME(0, 63),
	SAME_LOCALS_1_STACK_ITEM_FRAME(64, 127),
	RESERVERED_FOR_FUTURE_USE(128, 246),
	SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED(247, 247),
	CHOP_FRAME(248, 250),
	SAME_FRAME_EXTENDED(251, 251),
	APPEND_FRAME(252, 254),
	FULL_FRAME(255, 255);

	/**
	 * inclusive
	 */
	private final int lowerBound;

	/**
	 * inclusive
	 */
	private final int upperBound;

	private StackMapFrameType(int lowerBound, int upperBound)
	{
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	/**
	 * @param value
	 *            between 0 and 255 (both inclusive)
	 * @return
	 */
	public static StackMapFrameType fromValue(int value)
	{
		for (StackMapFrameType type : values())
		{
			if (type.getLowerBound() <= value && value <= type.getUpperBound())
			{
				return type;
			}
		}
		return null;
	}

	public int getLowerBound()
	{
		return lowerBound;
	}

	public int getUpperBound()
	{
		return upperBound;
	}
}
