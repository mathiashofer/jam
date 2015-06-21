package at.mhofer.jam.data.attributes;

public class SignatureAttribute extends AttributeInfo
{
	/**
	 * The value of the signature_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Utf8_info structure (§4.4.7) representing a class signature if
	 * this Signature attribute is an attribute of a ClassFile structure; a
	 * method signature if this Signature attribute is an attribute of a
	 * method_info structure; or a field signature otherwise.
	 */
	private int signatureIndex;

	public SignatureAttribute(int attributeNameIndex, long attributeLength, int signatureIndex)
	{
		super(attributeNameIndex, attributeLength);
		this.signatureIndex = signatureIndex;
	}

	public int getSignatureIndex()
	{
		return signatureIndex;
	}
}
