package at.mhofer.jam;

import java.io.File;

import at.mhofer.jam.data.ClassFile;
import at.mhofer.jam.runtime.Processor;

public class JAM
{

	private static final String testcase1 = "C:\\Users\\Matz\\Projects\\workspace\\JAMTestCases\\bin\\at\\mhofer\\abma\\bsp1\\ForLoop.class";
	private static final String testcase2 = "C:\\Users\\Matz\\Projects\\workspace\\JAMTestCases\\bin\\at\\mhofer\\abma\\bsp2\\FibonacciTest.class";

	public static void main(String[] args) throws Exception
	{
		File classfile = new File(testcase1);
	
		ClassFile clazz = new ClassFile(classfile);
		Processor processor = new Processor(clazz);
		Thread processorThread = new Thread(processor);
		processorThread.start();		
	}
	
}
