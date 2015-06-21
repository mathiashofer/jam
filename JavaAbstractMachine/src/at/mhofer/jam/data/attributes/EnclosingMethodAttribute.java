package at.mhofer.jam.data.attributes;

public class EnclosingMethodAttribute extends AttributeInfo
{
	/**
	 * The value of the class_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Class_info structure (§4.4.1) representing the innermost class
	 * that encloses the declaration of the current class.
	 */
	private int classIndex;

	/**
	 * If the current class is not immediately enclosed by a method or
	 * constructor, then the value of the method_index item must be zero.
	 * 
	 * In particular, method_index must be zero if the current class was
	 * immediately enclosed in source code by an instance initializer, static
	 * initializer, instance variable initializer, or class variable
	 * initializer. (The first two concern both local classes and anonymous
	 * classes, while the last two concern anonymous classes declared on the
	 * right hand side of a field assignment.)
	 * 
	 * Otherwise, the value of the method_index item must be a valid index into
	 * the constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_NameAndType_info structure (§4.4.6) representing the name and
	 * type of a method in the class referenced by the class_index attribute
	 * above.
	 * 
	 * It is the responsibility of a Java compiler to ensure that the method
	 * identified via the method_index is indeed the closest lexically enclosing
	 * method of the class that contains this EnclosingMethod attribute.
	 */
	private int methodIndex;

	public EnclosingMethodAttribute(int attributeNameIndex, long attributeLength, int classIndex,
			int methodIndex)
	{
		super(attributeNameIndex, attributeLength);
		this.classIndex = classIndex;
		this.methodIndex = methodIndex;
	}

	public int getClassIndex()
	{
		return classIndex;
	}

	public int getMethodIndex()
	{
		return methodIndex;
	}
}
