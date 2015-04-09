package at.mhofer.jam.data.constantpool;

public class CpMethodHandleInfo implements CpInfo
{

	/**
	 * The value of the reference_kind item must be in the range 1 to 9. The
	 * value denotes the kind of this method handle, which characterizes its
	 * bytecode behavior (§5.4.3.5).
	 */
	private byte referenceKind;

	/**
	 * The value of the reference_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be as
	 * follows:
	 * 
	 * • If the value of the reference_kind item is 1 (REF_getField), 2
	 * (REF_getStatic), 3 (REF_putField), or 4 (REF_putStatic), then the
	 * constant_pool entry at that index must be a CONSTANT_Fieldref_info
	 * (§4.4.2) structure representing a field for which a method handle is to
	 * be created.
	 * 
	 * • If the value of the reference_kind item is 5 (REF_invokeVirtual) or 8
	 * (REF_newInvokeSpecial), then the constant_pool entry at that index must
	 * be a CONSTANT_Methodref_info structure (§4.4.2) representing a class's
	 * method or constructor (§2.9) for which a method handle is to be created.
	 * 
	 * 
	 * • If the value of the reference_kind item is 6 (REF_invokeStatic) or 7
	 * (REF_invokeSpecial), then if the class file version number is less than
	 * 52.0, the constant_pool entry at that index must be a
	 * CONSTANT_Methodref_info structure representing a class's method for which
	 * a method handle is to be created; if the class file version number is
	 * 52.0 or above, the constant_pool entry at that index must be either a
	 * CONSTANT_Methodref_info structure or a CONSTANT_InterfaceMethodref_info
	 * structure (§4.4.2) representing a class's or interface's method for which
	 * a method handle is to be created.
	 * 
	 * • If the value of the reference_kind item is 9 (REF_invokeInterface),
	 * then the constant_pool entry at that index must be a
	 * CONSTANT_InterfaceMethodref_info structure representing an interface's
	 * method for which a method handle is to be created.
	 * 
	 * If the value of the reference_kind item is 5 (REF_invokeVirtual), 6
	 * (REF_invokeStatic), 7 (REF_invokeSpecial), or 9 (REF_invokeInterface),
	 * the name of the method represented by a CONSTANT_Methodref_info structure
	 * or a CONSTANT_InterfaceMethodref_info structure must not be <init> or
	 * <clinit>. If the value is 8 (REF_newInvokeSpecial), the name of the
	 * method represented by a CONSTANT_Methodref_info structure must be <init>.
	 */
	private int referenceIndex;

	public CpMethodHandleInfo(byte referenceKind, int referenceIndex)
	{
		this.referenceKind = referenceKind;
		this.referenceIndex = referenceIndex;
	}

	@Override
	public CpTag getTag()
	{
		return CpTag.METHOD_HANDLE;
	}

	public byte getReferenceKind()
	{
		return referenceKind;
	}

	public int getReferenceIndex()
	{
		return referenceIndex;
	}

}
