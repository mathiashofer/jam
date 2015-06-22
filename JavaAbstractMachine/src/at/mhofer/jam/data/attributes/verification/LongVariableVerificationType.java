package at.mhofer.jam.data.attributes.verification;

/**
 * A verification type that specifies two locations in the local variable array
 * or in the operand stack
 * 
 * The Long_variable_info item indicates that the first of two locations has the
 * verification type long.
 * 
 * @author Mathias
 *
 */
public class LongVariableVerificationType implements VerificationTypeInfo
{

	@Override
	public VerificationTypeTag getTag()
	{
		return VerificationTypeTag.LONG;
	}

}
