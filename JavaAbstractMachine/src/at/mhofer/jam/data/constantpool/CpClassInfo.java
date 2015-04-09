package at.mhofer.jam.data.constantpool;

/**
 * The CONSTANT_Class_info structure is used to represent a class or an
 * interface
 * 
 * @author Mathias
 *
 */
public class CpClassInfo implements CpInfo
{

	/**
	 * The value of the name_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) representing a valid binary class
	 * or interface name encoded in internal form (§4.2.1).
	 */
	private int nameIndex;

	public CpClassInfo(int nameIndex)
	{
		this.nameIndex = nameIndex;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.CLASS;
	}

	public int getNameIndex()
	{
		return nameIndex;
	}

}
