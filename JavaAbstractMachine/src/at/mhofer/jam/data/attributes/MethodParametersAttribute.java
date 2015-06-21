package at.mhofer.jam.data.attributes;

public class MethodParametersAttribute extends AttributeInfo
{
	/**
	 * The value of the parameters_count item indicates the number of parameter
	 * descriptors in the method descriptor (§4.3.3) referenced by the
	 * descriptor_index of the attribute's enclosing method_info structure.
	 */
	private short parametersCount;

	private ParametersTableEntry[] parameters;

	public MethodParametersAttribute(int attributeNameIndex, long attributeLength,
			short parametersCount, ParametersTableEntry[] parameters)
	{
		super(attributeNameIndex, attributeLength);
		this.parametersCount = parametersCount;
		this.parameters = parameters;
	}

	public short getParametersCount()
	{
		return parametersCount;
	}

	public ParametersTableEntry[] getParameters()
	{
		return parameters;
	}
}
