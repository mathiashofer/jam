package at.mhofer.jam.data;

import java.util.HashMap;
import java.util.Map;

import at.mhofer.jam.data.constantpool.CpTag;
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
	
	private static final Map<CpTag, CpInfoReader> cpReaders = new HashMap<CpTag, CpInfoReader>();
	
	static
	{
		cpReaders.put(CpTag.CLASS, new CpClassInfoReader());
		cpReaders.put(CpTag.DOUBLE, new CpDoubleInfoReader());
		cpReaders.put(CpTag.FIELDREF, new CpFieldRefInfoReader());
		cpReaders.put(CpTag.FLOAT, new CpFloatInfoReader());
		cpReaders.put(CpTag.INTEGER, new CpIntegerInfoReader());
		cpReaders.put(CpTag.INTERFACE_METHODREF, new CpInterfaceMethodrefInfoReader());
		cpReaders.put(CpTag.INVOKE_DYNAMIC, new CpInvokeDynamicInfoReader());
		cpReaders.put(CpTag.LONG, new CpLongInfoReader());
		cpReaders.put(CpTag.METHOD_HANDLE, new CpMethodHandleInfoReader());
		cpReaders.put(CpTag.METHOD_TYPE, new CpMethodTypeInfoReader());
		cpReaders.put(CpTag.METHODREF, new CpMethodRefInfoReader());
		cpReaders.put(CpTag.NAME_AND_TYPE, new CpNameAndTypeInfoReader());
		cpReaders.put(CpTag.STRING, new CpStringInfoReader());
		cpReaders.put(CpTag.UTF8, new CpUTF8InfoReader());
	}
	
	
	public static CpInfoReader getReader(CpTag tag)
	{
		return cpReaders.get(tag);
	}

}
