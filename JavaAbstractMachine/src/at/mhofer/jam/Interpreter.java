package at.mhofer.jam;

import java.io.File;

import at.mhofer.jam.data.ClassFile;

public class Interpreter
{

	public static void main(String[] args) throws Exception
	{
		File classfile = new File("C:\\Users\\Matz\\Projects\\workspace\\InterpreterBsp1\\bin\\at\\mhofer\\abma\\bsp1\\ForLoop.class");
	
		ClassFile clazz = new ClassFile(classfile);
		
		System.out.println(clazz);
	}
	
}
