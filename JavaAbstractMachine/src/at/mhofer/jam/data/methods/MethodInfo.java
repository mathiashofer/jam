package at.mhofer.jam.data.methods;

import java.util.Arrays;
import java.util.HashSet;

import at.mhofer.jam.data.AccessFlag;
import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.CodeAttribute;

public class MethodInfo
{
	private HashSet<AccessFlag> accessFlags;

	private int nameIndex;

	private int descriptorIndex;

	private int attributesCount;

	private AttributeInfo[] attributes;

	/**
	 * If the method is either native or abstract, its method_info structure
	 * must not have a Code attribute in its attributes table. Otherwise, its
	 * method_info structure must have exactly one Code attribute in its
	 * attributes table.
	 */
	private CodeAttribute codeAttribute;

	public MethodInfo(AccessFlag[] accessFlags, int nameIndex, int descriptorIndex,
			int attributesCount, AttributeInfo[] attributes, CodeAttribute codeAttribute)
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
		this.codeAttribute = codeAttribute;
	}

	public CodeAttribute getCodeAttribute()
	{
		return codeAttribute;
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

	@Override
	public String toString()
	{
		return "MethodInfo [accessFlags=" + accessFlags + ", nameIndex=" + nameIndex
				+ ", descriptorIndex=" + descriptorIndex + ", attributesCount=" + attributesCount
				+ ", attributes=" + Arrays.toString(attributes) + "]";
	}
}
