package at.mhofer.jam.data.attributes.stack;

/**
 * 
 * @author Mathias
 *
 */
public abstract class StackMapFrame
{
	
	private int typeValue;
	
	private StackMapFrameType type;
	
	/**
	 * @param frameType tag between 0 and 255 (both inclusive)
	 */
	public StackMapFrame(int frameType)
	{
		this.typeValue = frameType;
	}
	
	public StackMapFrameType getType()
	{
		return type;
	}

	public int getTypeValue()
	{
		return typeValue;
	}
}
