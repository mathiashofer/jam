package at.mhofer.jam.data.fields;

import java.util.HashSet;

import at.mhofer.jam.data.AccessFlag;
import at.mhofer.jam.data.attributes.AttributeInfo;

public class FieldInfo
{

	/**
	 * Stores all AccessFlags for this Field. A HashSet is used, because of its
	 * constant time for contains().
	 */
	private HashSet<AccessFlag> accessFlags;

	private int nameIndex;

	private int descriptorIndex;

	private short attributesCount;

	private AttributeInfo[] attributes;

	public FieldInfo(AccessFlag[] accessFlags, int nameIndex, int descriptorIndex,
			short attributesCount, AttributeInfo[] attributes)
	{
		super();
		this.accessFlags = new HashSet<AccessFlag>();
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

	public short getAttributesCount()
	{
		return attributesCount;
	}

	public AttributeInfo[] getAttributes()
	{
		return attributes;
	}

}
