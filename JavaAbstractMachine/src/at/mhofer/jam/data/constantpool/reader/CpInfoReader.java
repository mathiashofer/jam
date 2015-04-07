package at.mhofer.jam.data.constantpool.reader;

import java.io.DataInputStream;
import java.io.IOException;

import at.mhofer.jam.data.constantpool.CpInfo;

public interface CpInfoReader
{
	
	public CpInfo readInfo(DataInputStream in) throws IOException;

}
