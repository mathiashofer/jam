package at.mhofer.jam.data.attributes;

public class InnerClassesAttribute extends AttributeInfo
{
	/**
	 * The value of the number_of_classes item indicates the number of entries
	 * in the classes array.
	 */
	private int numberOfClasses;

	/**
	 * Every CONSTANT_Class_info entry in the constant_pool table which
	 * represents a class or interface C that is not a package member must have
	 * exactly one corresponding entry in the classes array.
	 */
	private ClassInfo[] classes;

	public InnerClassesAttribute(int attributeNameIndex, long attributeLength, int numberOfClasses,
			ClassInfo[] classes)
	{
		super(attributeNameIndex, attributeLength);
		this.numberOfClasses = numberOfClasses;
		this.classes = classes;
	}

	public int getNumberOfClasses()
	{
		return numberOfClasses;
	}

	public ClassInfo[] getClasses()
	{
		return classes;
	}
}
