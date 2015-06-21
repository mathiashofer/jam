package at.mhofer.jam.data.attributes;

public class AnnotationTableEntry
{	
	private int typeIndex;
	
	private int numElementValuePairs;
	
	private ElementValuePair[] elementValuePairs;

	public AnnotationTableEntry(int typeIndex, int numElementValuePairs,
			ElementValuePair[] elementValuePairs)
	{
		super();
		this.typeIndex = typeIndex;
		this.numElementValuePairs = numElementValuePairs;
		this.elementValuePairs = elementValuePairs;
	}

	public int getTypeIndex()
	{
		return typeIndex;
	}

	public int getNumElementValuePairs()
	{
		return numElementValuePairs;
	}

	public ElementValuePair[] getElementValuePairs()
	{
		return elementValuePairs;
	}
}
