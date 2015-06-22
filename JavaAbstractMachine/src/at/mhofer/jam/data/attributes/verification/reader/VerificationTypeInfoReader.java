package at.mhofer.jam.data.attributes.verification.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.DataReader;
import at.mhofer.jam.data.attributes.verification.DoubleVariableVerificationType;
import at.mhofer.jam.data.attributes.verification.FloatVariableVerificationType;
import at.mhofer.jam.data.attributes.verification.IntegerVariableVerificationType;
import at.mhofer.jam.data.attributes.verification.LongVariableVerificationType;
import at.mhofer.jam.data.attributes.verification.NullVariableVerificationType;
import at.mhofer.jam.data.attributes.verification.ObjectVariableVerificationType;
import at.mhofer.jam.data.attributes.verification.TopVariableVerificationType;
import at.mhofer.jam.data.attributes.verification.UninitializedThisVariableVerificationType;
import at.mhofer.jam.data.attributes.verification.UninitializedVariableVerificationInfo;
import at.mhofer.jam.data.attributes.verification.VerificationTypeInfo;
import at.mhofer.jam.data.attributes.verification.VerificationTypeTag;

public class VerificationTypeInfoReader implements DataReader<VerificationTypeInfo>
{

	@Override
	public VerificationTypeInfo readData(DataInputStream in) throws IOException
	{
		// TODO: spaghetticode mit besserer loesung ersetzen
		VerificationTypeInfo info = null;
		int tag = in.readUnsignedByte();
		if (VerificationTypeTag.TOP.getValue() == tag)
		{
			info = new TopVariableVerificationType();
		}
		else if (VerificationTypeTag.INTEGER.getValue() == tag)
		{
			info = new IntegerVariableVerificationType();
		}
		else if (VerificationTypeTag.FLOAT.getValue() == tag)
		{
			info = new FloatVariableVerificationType();
		}
		else if (VerificationTypeTag.NULL.getValue() == tag)
		{
			info = new NullVariableVerificationType();
		}
		else if (VerificationTypeTag.UNINITIALIZED_THIS.getValue() == tag)
		{
			info = new UninitializedThisVariableVerificationType();
		}
		else if (VerificationTypeTag.OBJECT.getValue() == tag)
		{
			int cpoolIndex = in.readUnsignedShort();
			info = new ObjectVariableVerificationType(cpoolIndex);
		}
		else if (VerificationTypeTag.UNINITIALIZED.getValue() == tag)
		{
			int offset = in.readUnsignedShort();
			info = new UninitializedVariableVerificationInfo(offset);
		}
		else if (VerificationTypeTag.LONG.getValue() == tag)
		{
			info = new LongVariableVerificationType();
		}
		else if (VerificationTypeTag.DOUBLE.getValue() == tag)
		{
			info = new DoubleVariableVerificationType();
		}

		return info;
	}

}
