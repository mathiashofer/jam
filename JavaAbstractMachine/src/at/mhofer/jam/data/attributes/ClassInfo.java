package at.mhofer.jam.data.attributes;

public class ClassInfo
{
	/**
	 * The value of the inner_class_info_index item must be a valid index into
	 * the constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Class_info structure representing C. The remaining items in the
	 * classes array entry give information about C.
	 */
	private int innerClassInfoIndex;

	/**
	 * If C is not a member of a class or an interface (that is, if C is a
	 * top-level class or interface (JLS §7.6) or a local class (JLS §14.3) or
	 * an anonymous class (JLS §15.9.5)), the value of the
	 * outer_class_info_index item must be zero.
	 * 
	 * Otherwise, the value of the outer_class_info_index item must be a valid
	 * index into the constant_pool table, and the entry at that index must be a
	 * CONSTANT_Class_info structure representing the class or interface of
	 * which C is a member.
	 */
	private int outerClassInfoIndex;

	/**
	 * If C is anonymous (JLS §15.9.5), the value of the inner_name_index item
	 * must be zero.
	 * 
	 * Otherwise, the value of the inner_name_index item must be a valid index
	 * into the constant_pool table, and the entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) that represents the original simple
	 * name of C, as given in the source code from which this class file was
	 * compiled.
	 */
	private int innerNameIndex;

	/**
	 * The value of the inner_class_access_flags item is a mask of flags used to
	 * denote access permissions to and properties of class or interface C as
	 * declared in the source code from which this class file was compiled. It
	 * is used by a compiler to recover the original information when source
	 * code is not available. The flags are specified in Table 4.7.6-A.
	 */
	private int innerClassAccessFlags;

	public ClassInfo(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex,
			int innerClassAccessFlags)
	{
		super();
		this.innerClassInfoIndex = innerClassInfoIndex;
		this.outerClassInfoIndex = outerClassInfoIndex;
		this.innerNameIndex = innerNameIndex;
		this.innerClassAccessFlags = innerClassAccessFlags;
	}

	public int getInnerClassInfoIndex()
	{
		return innerClassInfoIndex;
	}

	public int getOuterClassInfoIndex()
	{
		return outerClassInfoIndex;
	}

	public int getInnerNameIndex()
	{
		return innerNameIndex;
	}

	public int getInnerClassAccessFlags()
	{
		return innerClassAccessFlags;
	}
}
