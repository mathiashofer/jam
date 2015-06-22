package at.mhofer.jam.data.attributes.verification;

/**
 * The Uninitialized_variable_info item indicates that the location has the
 * verification type uninitialized(Offset). The Offset item indicates the
 * offset, in the code array of the Code attribute that contains this
 * StackMapTable attribute, of the new instruction (§new) that created the
 * object being stored in the location.
 * 
 * @author Mathias
 *
 */
public class UninitializedVariableVerificationInfo implements VerificationTypeInfo
{
	private int offset;

	public UninitializedVariableVerificationInfo(int offset)
	{
		this.offset = offset;
	}

	@Override
	public VerificationTypeTag getTag()
	{
		return VerificationTypeTag.UNINITIALIZED;
	}

	public int getOffset()
	{
		return offset;
	}
}
