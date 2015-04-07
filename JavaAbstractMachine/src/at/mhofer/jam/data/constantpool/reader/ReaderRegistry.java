package at.mhofer.jam.data.constantpool.reader;

import java.util.HashMap;
import java.util.Map;

import at.mhofer.jam.data.constantpool.CpTag;

public final class ReaderRegistry
{
	
	private static final Map<CpTag, CpInfoReader> readers = new HashMap<CpTag, CpInfoReader>();
	
	static
	{
		readers.put(CpTag.CLASS, new CpClassInfoReader());
		readers.put(CpTag.DOUBLE, new CpDoubleInfoReader());
		readers.put(CpTag.FIELDREF, new CpFieldRefInfoReader());
		readers.put(CpTag.FLOAT, new CpFloatInfoReader());
		readers.put(CpTag.INTEGER, new CpIntegerInfoReader());
		readers.put(CpTag.INTERFACE_METHODREF, new CpInterfaceMethodrefInfoReader());
		readers.put(CpTag.INVOKE_DYNAMIC, new CpInvokeDynamicInfoReader());
		readers.put(CpTag.LONG, new CpLongInfoReader());
		readers.put(CpTag.METHOD_HANDLE, new CpMethodHandleInfoReader());
		readers.put(CpTag.METHOD_TYPE, new CpMethodTypeInfoReader());
		readers.put(CpTag.METHODREF, new CpMethodRefInfoReader());
		readers.put(CpTag.NAME_AND_TYPE, new CpNameAndTypeInfoReader());
		readers.put(CpTag.STRING, new CpStringInfoReader());
		readers.put(CpTag.UTF8, new CpUTF8InfoReader());
	}
	
	
	public static CpInfoReader getReader(CpTag tag)
	{
		return readers.get(tag);
	}

}
