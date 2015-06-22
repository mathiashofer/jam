package at.mhofer.jam.data.attributes.verification;

public class NullVariableVerificationType implements VerificationTypeInfo
{

	@Override
	public VerificationTypeTag getTag()
	{
		return VerificationTypeTag.NULL;
	}

}
