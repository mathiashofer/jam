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
import at.mhofer.jam.data.fields.FieldInfo;
import at.mhofer.jam.data.fields.FieldInfoReader;

/**
 * Represents the class file in memory
 * 
 * @author Mathias
 *
 */
public class ClassFile
{
	private int magic;
	
	private int minor_version;
	
	private int major_version;
	
	private int constant_pool_count;
	
	private CpInfo[] constant_pool;
	
	private int fields_count;
	
	private FieldInfo[] fields;
	
	public ClassFile(File clazz) throws IOException
	{
		this(new FileInputStream(clazz));
	}
	
	public ClassFile(InputStream clazz) throws IOException
	{
		DataInputStream in = new DataInputStream(new BufferedInputStream(clazz));
		
		this.magic = in.readInt();
		this.minor_version = in.readUnsignedShort();
		this.major_version = in.readUnsignedShort();
		
		// Read constant pool
		this.constant_pool_count = in.readUnsignedShort();
		this.constant_pool = new CpInfo[constant_pool_count - 1];
		for (int i = 0; i < constant_pool_count - 1; i++)
		{
			byte tagCode = in.readByte();
			CpTag tag = CpTag.fromValue(tagCode);
			CpInfoReader reader = ReaderRegistry.getReader(tag);
			CpInfo info = reader.readData(in);
			constant_pool[i] = info;
		}
		
		// Read fields
		FieldInfoReader fieldReader = new FieldInfoReader();
		this.fields_count = in.readUnsignedShort();
		this.fields = new FieldInfo[fields_count];
		for (int i = 0; i < fields_count; i++)
		{
			fields[i] = fieldReader.readData(in);
		}
		
	}

	@Override
	public String toString()
	{
		return "ClassFile [magic=" + magic + ", minor_version=" + minor_version
				+ ", major_version=" + major_version + ", constant_pool_count="
				+ constant_pool_count + ", constant_pool=" + Arrays.toString(constant_pool)
				+ ", fields_count=" + fields_count + ", fields=" + Arrays.toString(fields) + "]";
	}


}
