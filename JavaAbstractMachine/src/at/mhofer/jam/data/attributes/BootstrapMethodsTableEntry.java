package at.mhofer.jam.data.attributes;

public class BootstrapMethodsTableEntry
{
	private int bootstrapMethodRef;
	
	private int numBootstrapArguments;
	
	private int[] bootstrapArguments;

	public BootstrapMethodsTableEntry(int bootstrapMethodRef, int numBootstrapArguments,
			int[] bootstrapArguments)
	{
		super();
		this.bootstrapMethodRef = bootstrapMethodRef;
		this.numBootstrapArguments = numBootstrapArguments;
		this.bootstrapArguments = bootstrapArguments;
	}

	public int getBootstrapMethodRef()
	{
		return bootstrapMethodRef;
	}

	public int getNumBootstrapArguments()
	{
		return numBootstrapArguments;
	}

	public int[] getBootstrapArguments()
	{
		return bootstrapArguments;
	}
}
