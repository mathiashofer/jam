package at.mhofer.jam.data.attributes;

public class ParametersTableEntry
{
	private int nameIndex;
	
	private int accessFlags;

	public ParametersTableEntry(int nameIndex, int accessFlags)
	{
		super();
		this.nameIndex = nameIndex;
		this.accessFlags = accessFlags;
	}

	public int getNameIndex()
	{
		return nameIndex;
	}

	public int getAccessFlags()
	{
		return accessFlags;
	}
}
