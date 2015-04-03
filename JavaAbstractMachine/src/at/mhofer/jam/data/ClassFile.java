package at.mhofer.jam.data;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFile
{
	
	private int magic;
	
	private short minor_version;
	private short major_version;
	private short constant_pool_count;
	
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
	}

	@Override
	public String toString()
	{
		return "ClassFile [magic=" + magic + ", minor_version=" + minor_version
				+ ", major_version=" + major_version + ", constant_pool_count="
				+ constant_pool_count + "]";
	}
}
