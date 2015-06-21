package at.mhofer.jam.data.attributes;

public class BootstrapMethodsAttribute extends AttributeInfo
{
	private int numBootstrapMethods;
	
	private BootstrapMethodsTableEntry[] bootstrapMethods;

	public BootstrapMethodsAttribute(int attributeNameIndex, long attributeLength,
			int numBootstrapMethods, BootstrapMethodsTableEntry[] bootstrapMethods)
	{
		super(attributeNameIndex, attributeLength);
		this.numBootstrapMethods = numBootstrapMethods;
		this.bootstrapMethods = bootstrapMethods;
	}

	public int getNumBootstrapMethods()
	{
		return numBootstrapMethods;
	}

	public BootstrapMethodsTableEntry[] getBootstrapMethods()
	{
		return bootstrapMethods;
	}
}
