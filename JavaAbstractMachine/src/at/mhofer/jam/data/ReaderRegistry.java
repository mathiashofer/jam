package at.mhofer.jam.data;

import java.util.HashMap;
import java.util.Map;

import at.mhofer.jam.data.constantpool.ConstantPoolTag;
import at.mhofer.jam.data.constantpool.reader.ClassInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.ConstantPoolInfoReader;
import at.mhofer.jam.data.constantpool.reader.DoubleInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.FieldRefInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.FloatInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.IntegerInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.InterfaceMethodrefInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.InvokeDynamicInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.LongInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.MethodHandleInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.MethodRefInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.MethodTypeInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.NameAndTypeInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.StringInfoConstantReader;
import at.mhofer.jam.data.constantpool.reader.UTF8InfoConstantReader;

public final class ReaderRegistry
{

	private static final Map<ConstantPoolTag, ConstantPoolInfoReader> constantPoolReaders = new HashMap<ConstantPoolTag, ConstantPoolInfoReader>();
	
	static
	{
		// initialize constant pool readers
		constantPoolReaders.put(ConstantPoolTag.CLASS, new ClassInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.DOUBLE, new DoubleInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.FIELDREF, new FieldRefInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.FLOAT, new FloatInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.INTEGER, new IntegerInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.INTERFACE_METHODREF,
				new InterfaceMethodrefInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.INVOKE_DYNAMIC,
				new InvokeDynamicInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.LONG, new LongInfoConstantReader());
		constantPoolReaders
				.put(ConstantPoolTag.METHOD_HANDLE, new MethodHandleInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.METHOD_TYPE, new MethodTypeInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.METHODREF, new MethodRefInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.NAME_AND_TYPE, new NameAndTypeInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.STRING, new StringInfoConstantReader());
		constantPoolReaders.put(ConstantPoolTag.UTF8, new UTF8InfoConstantReader());
	}

	public static ConstantPoolInfoReader getConstantPoolReader(ConstantPoolTag tag)
	{
		return constantPoolReaders.get(tag);
	}

}
