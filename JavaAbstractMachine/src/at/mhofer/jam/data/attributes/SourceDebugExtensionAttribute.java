package at.mhofer.jam.data.attributes;

public class SourceDebugExtensionAttribute extends AttributeInfo
{
	/**
	 * The debug_extension array holds extended debugging information which has
	 * no semantic effect on the Java Virtual Machine. The information is
	 * represented using a modified UTF-8 string (§4.4.7) with no terminating
	 * zero byte.
	 */
	private byte[] debugExtension;

	public SourceDebugExtensionAttribute(int attributeNameIndex, long attributeLength,
			byte[] debugExtension)
	{
		super(attributeNameIndex, attributeLength);
		this.debugExtension = debugExtension;
	}

	public byte[] getDebugExtension()
	{
		return debugExtension;
	}
}
