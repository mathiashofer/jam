package at.mhofer.jam.data.attributes;

public class RuntimeInvisibleParameterAnnotationsAttribute extends AttributeInfo
{
	private short numParameters;
	
	private ParameterAnnotationsTableEntry[] parameterAnnotations;
	
	public RuntimeInvisibleParameterAnnotationsAttribute(int attributeNameIndex,
			long attributeLength, short numParameters,
			ParameterAnnotationsTableEntry[] parameterAnnotations)
	{
		super(attributeNameIndex, attributeLength);
		this.numParameters = numParameters;
		this.parameterAnnotations = parameterAnnotations;
	}

	public short getNumParameters()
	{
		return numParameters;
	}

	public ParameterAnnotationsTableEntry[] getParameterAnnotations()
	{
		return parameterAnnotations;
	}
}
