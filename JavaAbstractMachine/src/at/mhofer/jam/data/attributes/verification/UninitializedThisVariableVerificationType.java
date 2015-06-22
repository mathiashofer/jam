package at.mhofer.jam.data.attributes.verification;

public class UninitializedThisVariableVerificationType implements VerificationTypeInfo
{

	@Override
	public VerificationTypeTag getTag()
	{
		return VerificationTypeTag.UNINITIALIZED_THIS;
	}

}
