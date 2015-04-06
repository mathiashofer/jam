package at.mhofer.jam.data.constantpool.reader;

import java.util.HashMap;
import java.util.Map;

import at.mhofer.jam.data.constantpool.CpTag;

public final class ReaderRegistry
{
	
	private static Map<CpTag, CpReader> readers;
	
	static
	{
		readers = new HashMap<CpTag, CpReader>();
	
	}
	
	
	public static CpReader getReader(CpTag tag)
	{
		return readers.get(tag);
	}

}
