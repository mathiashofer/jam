package at.mhofer.jam.data.methods;

import java.util.HashSet;

import at.mhofer.jam.data.AccessFlag;
import at.mhofer.jam.data.attributes.AttributeInfo;

public class MethodInfo
{
	private HashSet<AccessFlag> accessFlags;

	private int nameIndex;

	private int descriptorIndex;

	private int attributesCount;

	private AttributeInfo[] attributes;

	public MethodInfo(AccessFlag[] accessFlags, int nameIndex, int descriptorIndex,
			int attributesCount, AttributeInfo[] attributes)
	{
		super();

		if (attributes == null || attributesCount != attributes.length)
		{
			throw new IllegalArgumentException("attributesCount has to match attributes.length");
		}

		this.accessFlags = new HashSet<AccessFlag>(accessFlags.length);
		for (AccessFlag flag : accessFlags)
		{
			this.accessFlags.add(flag);
		}
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
		this.attributesCount = attributesCount;
		this.attributes = attributes;
	}

	public HashSet<AccessFlag> getAccessFlags()
	{
		return accessFlags;
	}

	public int getNameIndex()
	{
		return nameIndex;
	}

	public int getDescriptorIndex()
	{
		return descriptorIndex;
	}

	public int getAttributesCount()
	{
		return attributesCount;
	}

	public AttributeInfo[] getAttributes()
	{
		return attributes;
	}
}
