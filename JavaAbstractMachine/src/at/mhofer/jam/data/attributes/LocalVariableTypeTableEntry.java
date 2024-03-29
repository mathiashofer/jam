package at.mhofer.jam.data.attributes;

public class LocalVariableTypeTableEntry
{
	/**
	 * The given local variable must have a value at indices into the code array
	 * in the interval [start_pc, start_pc + length), that is, between start_pc
	 * inclusive and start_pc + length exclusive.
	 * 
	 * The value of start_pc must be a valid index into the code array of this
	 * Code attribute and must be the index of the opcode of an instruction.
	 * 
	 * The value of start_pc + length must either be a valid index into the code
	 * array of this Code attribute and be the index of the opcode of an
	 * instruction, or it must be the first index beyond the end of that code
	 * array.
	 */
	private int startPC;

	/**
	 * See startPC
	 */
	private int length;

	/**
	 * The value of the name_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must contain a
	 * CONSTANT_Utf8_info structure (�4.4.7) representing a valid unqualified
	 * name denoting a local variable (�4.2.2).
	 */
	private int nameIndex;

	/**
	 * The value of the signature_index item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must contain a
	 * CONSTANT_Utf8_info structure (�4.4.7) representing a field signature
	 * which encodes the type of a local variable in the source program
	 * (�4.7.9.1).
	 */
	private int signatureIndex;

	/**
	 * The given local variable must be at index in the local variable array of
	 * the current frame.
	 * 
	 * If the local variable at index is of type double or long, it occupies
	 * both index and index + 1.
	 */
	private int index;

	public LocalVariableTypeTableEntry(int startPC, int length, int nameIndex, int signatureIndex,
			int index)
	{
		super();
		this.startPC = startPC;
		this.length = length;
		this.nameIndex = nameIndex;
		this.signatureIndex = signatureIndex;
		this.index = index;
	}

	public int getStartPC()
	{
		return startPC;
	}

	public int getLength()
	{
		return length;
	}

	public int getNameIndex()
	{
		return nameIndex;
	}

	public int getSignatureIndex()
	{
		return signatureIndex;
	}

	public int getIndex()
	{
		return index;
	}
}
