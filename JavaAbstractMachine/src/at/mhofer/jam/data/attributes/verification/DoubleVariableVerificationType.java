package at.mhofer.jam.data.attributes.verification;

/**
 * A verification type that specifies two locations in the local variable array
 * or in the operand stack.
 * 
 * The Double_variable_info item indicates that the first of two locations has
 * the verification type double.
 * 
 * @author Mathias
 *
 */
public class DoubleVariableVerificationType implements VerificationTypeInfo
{

	@Override
	public VerificationTypeTag getTag()
	{
		return VerificationTypeTag.DOUBLE;
	}

}
