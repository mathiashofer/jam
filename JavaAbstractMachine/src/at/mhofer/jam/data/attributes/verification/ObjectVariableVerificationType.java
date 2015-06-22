package at.mhofer.jam.data.attributes.verification;

/**
 * The Object_variable_info item indicates that the location has the
 * verification type which is the class represented by the CONSTANT_Class_info
 * structure (§4.4.1) found in the constant_pool table at the index given by
 * cpool_index.
 * 
 * @author Mathias
 *
 */
public class ObjectVariableVerificationType implements VerificationTypeInfo
{

	private int cpoolIndex;

	public ObjectVariableVerificationType(int cpoolIndex)
	{
		this.cpoolIndex = cpoolIndex;
	}

	@Override
	public VerificationTypeTag getTag()
	{
		return VerificationTypeTag.OBJECT;
	}

	public int getCpoolIndex()
	{
		return cpoolIndex;
	}
}
