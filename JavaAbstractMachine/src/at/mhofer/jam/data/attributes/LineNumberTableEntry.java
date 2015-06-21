package at.mhofer.jam.data.attributes;

public class LineNumberTableEntry
{
	/**
	 * The value of the start_pc item must indicate the index into the code
	 * array at which the code for a new line in the original source file
	 * begins. The value of start_pc must be less than the value of the
	 * code_length item of the Code attribute of which this LineNumberTable is
	 * an attribute.
	 */
	private int startPC;

	/**
	 * The value of the line_number item must give the corresponding line number
	 * in the original source file.
	 */
	private int lineNumber;

	public LineNumberTableEntry(int startPC, int lineNumber)
	{
		super();
		this.startPC = startPC;
		this.lineNumber = lineNumber;
	}

	public int getStartPC()
	{
		return startPC;
	}

	public int getLineNumber()
	{
		return lineNumber;
	}
}
