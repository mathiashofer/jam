package at.mhofer.jam.data.attributes;

public class ExceptionIndexTableEntry
{
	/**
	 * The values of the two items start_pc and end_pc indicate the ranges in
	 * the code array at which the exception handler is active. The value of
	 * start_pc must be a valid index into the code array of the opcode of an
	 * instruction. The value of end_pc either must be a valid index into the
	 * code array of the opcode of an instruction or must be equal to
	 * code_length, the length of the code array. The value of start_pc must be
	 * less than the value of end_pc.
	 * 
	 * The start_pc is inclusive and end_pc is exclusive; that is, the exception
	 * handler must be active while the program counter is within the interval
	 * [start_pc, end_pc).
	 */
	private int startPC;

	/**
	 * See startPC
	 */
	private int endPC;

	/**
	 * The value of the handler_pc item indicates the start of the exception
	 * handler. The value of the item must be a valid index into the code array
	 * and must be the index of the opcode of an instruction.
	 */
	private int handlerPC;

	/**
	 * If the value of the catch_type item is nonzero, it must be a valid index
	 * into the constant_pool table. The constant_pool entry at that index must
	 * be a CONSTANT_Class_info structure (§4.4.1) representing a class of
	 * exceptions that this exception handler is designated to catch. The
	 * exception handler will be called only if the thrown exception is an
	 * instance of the given class or one of its subclasses.
	 * 
	 * The verifier checks that the class is Throwable or a subclass of
	 * Throwable (§4.9.2).
	 * 
	 * If the value of the catch_type item is zero, this exception handler is
	 * called for all exceptions.
	 * 
	 * This is used to implement finally (§3.13).
	 */
	private int catchType;

	public ExceptionIndexTableEntry(int startPC, int endPC, int handlerPC, int catchType)
	{
		this.startPC = startPC;
		this.endPC = endPC;
		this.handlerPC = handlerPC;
		this.catchType = catchType;
	}

	public int getStartPC()
	{
		return startPC;
	}

	public int getEndPC()
	{
		return endPC;
	}

	public int getHandlerPC()
	{
		return handlerPC;
	}

	public int getCatchType()
	{
		return catchType;
	}
}
