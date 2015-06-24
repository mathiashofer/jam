package at.mhofer.jam.data;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;

import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.attributes.reader.AttributeInfoReader;
import at.mhofer.jam.data.constantpool.ConstantPoolInfo;
import at.mhofer.jam.data.constantpool.ConstantPoolTag;
import at.mhofer.jam.data.constantpool.UTF8InfoConstant;
import at.mhofer.jam.data.constantpool.reader.ConstantPoolInfoReader;
import at.mhofer.jam.data.fields.FieldInfo;
import at.mhofer.jam.data.fields.FieldInfoReader;
import at.mhofer.jam.data.methods.MethodInfo;
import at.mhofer.jam.data.methods.MethodInfoReader;

/**
 * Represents a class file as specified in the JVM8 Spec.
 * 
 * @author Mathias
 *
 */
public class ClassFile
{
	/**
	 * The magic item supplies the magic number identifying the class file
	 * format; it has the value 0xCAFEBABE.
	 */
	private int magic;

	/**
	 * The values of the minor_version and major_version items are the minor and
	 * major version numbers of this class file. Together, a major and a minor
	 * version number determine the version of the class file format. If a class
	 * file has major version number M and minor version number m, we denote the
	 * version of its class file format as M.m. Thus, class file format versions
	 * may be ordered lexicographically, for example, 1.5 < 2.0 < 2.1.
	 */
	private int minorVersion;

	/**
	 * See minorVersion
	 */
	private int majorVersion;

	/**
	 * The value of the constant_pool_count item is equal to the number of
	 * entries in the constant_pool table plus one. A constant_pool index is
	 * considered valid if it is greater than zero and less than
	 * constant_pool_count, with the exception for constants of type long and
	 * double noted in §4.4.5.
	 */
	private int constantPoolCount;

	/**
	 * The constant_pool is a table of structures (§4.4) representing various
	 * string constants, class and interface names, field names, and other
	 * constants that are referred to within the ClassFile structure and its
	 * substructures. The format of each constant_pool table entry is indicated
	 * by its first "tag" byte.
	 * 
	 * The constant_pool table is indexed from 1 to constant_pool_count - 1.
	 */
	private ConstantPoolInfo[] constantPool;

	/**
	 * The value of the access_flags item is a mask of flags used to denote
	 * access permissions to and properties of this class or interface. The
	 * interpretation of each flag, when set, is specified in Table 4.1-A.
	 */
	private HashSet<AccessFlag> accessFlags;

	/**
	 * The value of the this_class item must be a valid index into the
	 * constant_pool table. The constant_pool entry at that index must be a
	 * CONSTANT_Class_info structure (§4.4.1) representing the class or
	 * interface defined by this class file.
	 */
	private int thisClass;

	/**
	 * For a class, the value of the super_class item either must be zero or
	 * must be a valid index into the constant_pool table. If the value of the
	 * super_class item is nonzero, the constant_pool entry at that index must
	 * be a CONSTANT_Class_info structure representing the direct superclass of
	 * the class defined by this class file. Neither the direct superclass nor
	 * any of its superclasses may have the ACC_FINAL flag set in the
	 * access_flags item of its ClassFile structure.
	 * 
	 * If the value of the super_class item is zero, then this class file must
	 * represent the class Object, the only class or interface without a direct
	 * superclass.
	 * 
	 * For an interface, the value of the super_class item must always be a
	 * valid index into the constant_pool table. The constant_pool entry at that
	 * index must be a CONSTANT_Class_info structure representing the class
	 * Object.
	 */
	private int superClass;

	/**
	 * The value of the interfaces_count item gives the number of direct
	 * superinterfaces of this class or interface type.
	 */
	private int interfacesCount;

	/**
	 * Each value in the interfaces array must be a valid index into the
	 * constant_pool table. The constant_pool entry at each value of
	 * interfaces[i], where 0 <= i < interfaces_count, must be a
	 * CONSTANT_Class_info structure representing an interface that is a direct
	 * superinterface of this class or interface type, in the left-to-right
	 * order given in the source for the type.
	 */
	private int[] interfaces;

	/**
	 * The value of the fields_count item gives the number of field_info
	 * structures in the fields table. The field_info structures represent all
	 * fields, both class variables and instance variables, declared by this
	 * class or interface type.
	 */
	private int fieldsCount;

	/**
	 * Each value in the fields table must be a field_info structure (§4.5)
	 * giving a complete description of a field in this class or interface. The
	 * fields table includes only those fields that are declared by this class
	 * or interface. It does not include items representing fields that are
	 * inherited from superclasses or superinterfaces.
	 */
	private FieldInfo[] fields;

	/**
	 * The value of the methods_count item gives the number of method_info
	 * structures in the methods table.
	 */
	private int methodsCount;

	/**
	 * Each value in the methods table must be a method_info structure (§4.6)
	 * giving a complete description of a method in this class or interface. If
	 * neither of the ACC_NATIVE and ACC_ABSTRACT flags are set in the
	 * access_flags item of amethod_info structure, the Java Virtual Machine
	 * instructions implementing the method are also supplied.
	 * 
	 * The method_info structures represent all methods declared by this class
	 * or interface type, including instance methods, class methods, instance
	 * initialization methods (§2.9), and any class or interface initialization
	 * method (§2.9). The methods table does not include items representing
	 * methods that are inherited from superclasses or superinterfaces.
	 */
	private MethodInfo[] methods;

	/**
	 * The value of the attributes_count item gives the number of attributes in
	 * the attributes table of this class.
	 */
	private int attributesCount;

	/**
	 * Each value of the attributes table must be an attribute_info structure
	 * (§4.7).
	 * 
	 * The attributes defined by this specification as appearing in the
	 * attributes table of a ClassFile structure are listed in Table 4.7-C.
	 * 
	 * The rules concerning attributes defined to appear in the attributes table
	 * of a ClassFile structure are given in §4.7.
	 * 
	 * The rules concerning non-predefined attributes in the attributes table of
	 * a ClassFile structure are given in §4.7.1.
	 */
	private AttributeInfo[] attributes;

	private MethodInfo initMethod;
	
	private int cpInitIndex;

	public ClassFile(File clazz) throws IOException
	{
		this(new FileInputStream(clazz));
	}

	public ClassFile(InputStream clazz) throws IOException
	{
		DataInputStream in = new DataInputStream(new BufferedInputStream(clazz));

		this.magic = in.readInt();
		this.minorVersion = in.readUnsignedShort();
		this.majorVersion = in.readUnsignedShort();

		// Read constant pool
		this.constantPoolCount = in.readUnsignedShort();
		// constant_pool_count - 1 elements
		this.constantPool = new ConstantPoolInfo[constantPoolCount];
		for (int i = 1; i < constantPoolCount; i++)
		{
			byte tagCode = in.readByte();
			ConstantPoolTag tag = ConstantPoolTag.fromValue(tagCode);
			ConstantPoolInfoReader reader = ReaderRegistry.getConstantPoolReader(tag);
			ConstantPoolInfo info = reader.readData(in);
			constantPool[i] = info;
			
			//check if the current constant equals "<init>"
			if (tag == ConstantPoolTag.UTF8)
			{
				String value = ((UTF8InfoConstant)info).getValue();
				if (value.equals("<init>"))
				{
					this.cpInitIndex = i;
				}
			}
		}

		// add the flags to a hashset, because of constant time "contains" check
		AccessFlag[] flags = AccessFlag.fromBytes(in.readUnsignedShort());
		this.accessFlags = new HashSet<AccessFlag>();
		for (AccessFlag flag : flags)
		{
			this.accessFlags.add(flag);
		}

		this.thisClass = in.readUnsignedShort();
		this.superClass = in.readUnsignedShort();

		// Read interfaces
		this.interfacesCount = in.readUnsignedShort();
		this.interfaces = new int[interfacesCount];
		for (int i = 0; i < interfacesCount; i++)
		{
			this.interfaces[i] = in.readUnsignedShort();
		}

		// Read fields
		FieldInfoReader fieldReader = new FieldInfoReader(constantPool);
		this.fieldsCount = in.readUnsignedShort();
		this.fields = new FieldInfo[fieldsCount];
		for (int i = 0; i < fieldsCount; i++)
		{
			fields[i] = fieldReader.readData(in);
		}

		// Read methods
		MethodInfoReader methodReader = new MethodInfoReader(constantPool);
		this.methodsCount = in.readUnsignedShort();
		this.methods = new MethodInfo[methodsCount];
		for (int i = 0; i < methodsCount; i++)
		{
			MethodInfo method = methodReader.readData(in);
			methods[i] = method;
			
			if(method.getNameIndex() == this.cpInitIndex)
			{
				this.initMethod = method;
			}
		}

		// Read attributes
		AttributeInfoReader attributeReader = new AttributeInfoReader(constantPool);
		this.attributesCount = in.readUnsignedShort();
		this.attributes = new AttributeInfo[attributesCount];
		for (int i = 0; i < attributesCount; i++)
		{
			attributes[i] = attributeReader.readData(in);
		}

		in.close();
	}

	public MethodInfo getInitMethod()
	{
		return initMethod;
	}
	
	public ConstantPoolInfo[] getConstantPool()
	{
		return constantPool;
	}

	public void printMethods()
	{
		for (MethodInfo info : methods)
		{
			int nameIndex = info.getNameIndex();
			ConstantPoolInfo cpInfo = constantPool[nameIndex];
			if (cpInfo.getTag() == ConstantPoolTag.UTF8)
			{
				String name = ((UTF8InfoConstant) cpInfo).getValue();
				System.out.println(name);
			}
		}
	}

	@Override
	public String toString()
	{
		return "ClassFile [magic=" + magic + ", minorVersion=" + minorVersion + ", majorVersion="
				+ majorVersion + ", constantPoolCount=" + constantPoolCount + ", constantPool="
				+ Arrays.toString(constantPool) + ", accessFlags=" + accessFlags + ", thisClass="
				+ thisClass + ", superClass=" + superClass + ", interfacesCount=" + interfacesCount
				+ ", interfaces=" + Arrays.toString(interfaces) + ", fieldsCount=" + fieldsCount
				+ ", fields=" + Arrays.toString(fields) + ", methodsCount=" + methodsCount
				+ ", methods=" + Arrays.toString(methods) + ", attributesCount=" + attributesCount
				+ ", attributes=" + Arrays.toString(attributes) + "]";
	}
}
