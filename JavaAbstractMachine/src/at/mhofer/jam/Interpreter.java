package at.mhofer.jam;

import java.io.File;
import java.util.Arrays;

import at.mhofer.jam.data.ClassFile;
import at.mhofer.jam.data.fields.AccessFlag;

public class Interpreter
{

	public static void main(String[] args) throws Exception
	{
		File classfile = new File("C:\\Users\\Matz\\Projects\\workspace\\InterpreterBsp1\\bin\\at\\mhofer\\abma\\bsp1\\ForLoop.class");
	
		ClassFile clazz = new ClassFile(classfile);
		
		System.out.println(clazz);
		
		int bytes = 0x0001 | 0x0010;
		System.out.println(Arrays.toString(AccessFlag.fromBytes(bytes)));
				
	}
	
}
