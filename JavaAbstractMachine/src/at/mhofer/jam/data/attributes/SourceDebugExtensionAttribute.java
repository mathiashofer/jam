package at.mhofer.jam.data.attributes;

import at.mhofer.jam.data.U4Array;

public class SourceDebugExtensionAttribute extends AttributeInfo
{
	/**
	 * The debug_extension array holds extended debugging information which has
	 * no semantic effect on the Java Virtual Machine. The information is
	 * represented using a modified UTF-8 string (§4.4.7) with no terminating
	 * zero byte.
	 */
	private U4Array<Byte> debugExtension;

	public SourceDebugExtensionAttribute(int attributeNameIndex, long attributeLength,
			U4Array<Byte> debugExtension)
	{
		super(attributeNameIndex, attributeLength);
		this.debugExtension = debugExtension;
	}

	public U4Array<Byte> getDebugExtension()
	{
		return debugExtension;
	}
}
