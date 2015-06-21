package at.mhofer.jam;

import java.io.File;

import at.mhofer.jam.data.ClassFile;

public class Interpreter
{

	private static final String testcase1 = "C:\\Users\\Matz\\Projects\\workspace\\JAMTestCases\\bin\\at\\mhofer\\abma\\bsp1\\ForLoop.class";
	private static final String testcase2 = "C:\\Users\\Matz\\Projects\\workspace\\JAMTestCases\\bin\\at\\mhofer\\abma\\bsp2\\FibonacciTest.class";

	
	
	public static void main(String[] args) throws Exception
	{
		File classfile = new File(testcase2);
	
		ClassFile clazz = new ClassFile(classfile);
		
		System.out.println(clazz);
				
		int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 2;
		long index = ((long)Integer.MAX_VALUE+1)*2;
		
		if (index < MAX_ARRAY_LENGTH)
		{
			System.out.println("array1 " + index);
		}
		else if (index >= ((long) MAX_ARRAY_LENGTH) * 2)
		{
			System.out.println("array3 " + (int) (index - (2 * MAX_ARRAY_LENGTH)));
		}
		else if (index >= MAX_ARRAY_LENGTH)
		{
			System.out.println("array2 " + (int) (index - MAX_ARRAY_LENGTH));
		}
		
		
//		new U4Array<Byte>(index);
	}
	
}
