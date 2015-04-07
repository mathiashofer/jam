package at.mhofer.jam.data;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import at.mhofer.jam.data.constantpool.CpInfo;
import at.mhofer.jam.data.constantpool.CpTag;
import at.mhofer.jam.data.constantpool.reader.CpInfoReader;
import at.mhofer.jam.data.constantpool.reader.ReaderRegistry;

/**
 * Represents the class file in memory
 * 
 * @author Mathias
 *
 */
public class ClassFile
{
	private int magic;
	
	private short minor_version;
	private short major_version;
	private short constant_pool_count;
	
	private CpInfo[] constant_pool;
	
	public ClassFile(File clazz) throws IOException
	{
		this(new FileInputStream(clazz));
	}
	
	public ClassFile(InputStream clazz) throws IOException
	{
		DataInputStream in = new DataInputStream(new BufferedInputStream(clazz));
		
		this.magic = in.readInt();
		this.minor_version = in.readShort();
		this.major_version = in.readShort();
		this.constant_pool_count = in.readShort();
		this.constant_pool = new CpInfo[constant_pool_count - 1];
		
		for (int i = 1; i < constant_pool_count - 1; i++)
		{
			byte tagCode = in.readByte();
			CpTag tag = CpTag.fromValue(tagCode);
			CpInfoReader reader = ReaderRegistry.getReader(tag);
			CpInfo info = reader.readInfo(in);
			constant_pool[i] = info;
		}
	}

	@Override
	public String toString()
	{
		return "ClassFile [magic=" + magic + ", minor_version=" + minor_version
				+ ", major_version=" + major_version + ", constant_pool_count="
				+ constant_pool_count + ", constant_pool=" + Arrays.toString(constant_pool) + "]";
	}

}
