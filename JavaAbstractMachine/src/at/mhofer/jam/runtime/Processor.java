package at.mhofer.jam.runtime;

import java.util.Stack;

import at.mhofer.jam.data.U4Array;
import at.mhofer.jam.data.methods.MethodInfo;
import at.mhofer.jam.runtime.data.StackFrame;

public class Processor implements Runnable
{
	
	
	private MethodInfo currentMethod;

	private Stack<StackFrame> frames;
	
	/**
	 * Program counter
	 */
	private int pc;
	
	private U4Array<Byte> instructions;

	@Override
	public void run()
	{
		//fetch
		Byte instruction = instructions.get(pc);
		
		
	}
	
}
