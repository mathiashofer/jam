package at.mhofer.jam.data.attributes;

/**
 * 
 * @author Mathias
 *
 */
public class RuntimeVisibleParameterAnnotationsAttribute extends AttributeInfo
{
	/**
	 * The value of the num_parameters item gives the number of formal
	 * parameters of the method represented by the method_info structure on
	 * which the annotation occurs.
	 * 
	 * This duplicates information that could be extracted from the method
	 * descriptor.
	 */
	private short numParameters;

	/**
	 * Each entry in the parameter_annotations table represents all of the
	 * runtime visible annotations on the declaration of a single formal
	 * parameter. The i'th entry in the table corresponds to the i'th formal
	 * parameter in the method descriptor (§4.3.3).
	 */
	private ParameterAnnotationsTableEntry[] parameterAnnotations;

	public RuntimeVisibleParameterAnnotationsAttribute(int attributeNameIndex,
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
