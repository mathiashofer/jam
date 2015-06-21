package at.mhofer.jam.data;

import java.util.HashMap;
import java.util.Map;

import at.mhofer.jam.data.constantpool.ConstantPoolTag;
import at.mhofer.jam.data.constantpool.reader.CpClassInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpDoubleInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpFieldRefInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpFloatInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpIntegerInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpInterfaceMethodrefInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpInvokeDynamicInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpLongInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpMethodHandleInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpMethodRefInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpMethodTypeInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpNameAndTypeInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpStringInfoReader;
import at.mhofer.jam.data.constantpool.reader.CpUTF8InfoReader;

public final class ReaderRegistry
{
	
	private static final Map<ConstantPoolTag, CpInfoReader> cpReaders = new HashMap<ConstantPoolTag, CpInfoReader>();
	
	static
	{
		cpReaders.put(ConstantPoolTag.CLASS, new CpClassInfoReader());
		cpReaders.put(ConstantPoolTag.DOUBLE, new CpDoubleInfoReader());
		cpReaders.put(ConstantPoolTag.FIELDREF, new CpFieldRefInfoReader());
		cpReaders.put(ConstantPoolTag.FLOAT, new CpFloatInfoReader());
		cpReaders.put(ConstantPoolTag.INTEGER, new CpIntegerInfoReader());
		cpReaders.put(ConstantPoolTag.INTERFACE_METHODREF, new CpInterfaceMethodrefInfoReader());
		cpReaders.put(ConstantPoolTag.INVOKE_DYNAMIC, new CpInvokeDynamicInfoReader());
		cpReaders.put(ConstantPoolTag.LONG, new CpLongInfoReader());
		cpReaders.put(ConstantPoolTag.METHOD_HANDLE, new CpMethodHandleInfoReader());
		cpReaders.put(ConstantPoolTag.METHOD_TYPE, new CpMethodTypeInfoReader());
		cpReaders.put(ConstantPoolTag.METHODREF, new CpMethodRefInfoReader());
		cpReaders.put(ConstantPoolTag.NAME_AND_TYPE, new CpNameAndTypeInfoReader());
		cpReaders.put(ConstantPoolTag.STRING, new CpStringInfoReader());
		cpReaders.put(ConstantPoolTag.UTF8, new CpUTF8InfoReader());
	}
	
	
	public static CpInfoReader getReader(ConstantPoolTag tag)
	{
		return cpReaders.get(tag);
	}

}
