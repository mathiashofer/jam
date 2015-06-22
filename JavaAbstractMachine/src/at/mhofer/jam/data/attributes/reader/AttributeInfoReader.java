package at.mhofer.jam.data.attributes.reader;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import at.mhofer.jam.data.DataReader;
import at.mhofer.jam.data.DataSource;
import at.mhofer.jam.data.attributes.AttributeInfo;
import at.mhofer.jam.data.constantpool.ConstantPoolInfo;
import at.mhofer.jam.data.constantpool.ConstantPoolTag;
import at.mhofer.jam.data.constantpool.UTF8InfoConstant;

/**
 * Marker Interface
 * 
 * @author Mathias
 *
 */
public class AttributeInfoReader implements DataReader<AttributeInfo>
{
	private static final Map<String, AttributeInfoReaderStrategy> strategies = new HashMap<String, AttributeInfoReaderStrategy>();

	private Logger logger = LogManager.getLogger(AttributeInfoReader.class);

	/**
	 * This DataSource is used by some strategies, in order to have access to
	 * the current constant pool.
	 * 
	 * A DataSource is needed, because the Strategies Map has a static modifier
	 * and all strategies are initialized only once. But because the
	 * AttributeInfoReader class can get instantiated at any time, there has to
	 * be a way, to inform the strategies of the currently used Constant Pool.
	 */
	private static DataSource<ConstantPoolInfo[]> constantPoolSource = new DataSource<ConstantPoolInfo[]>();

	static
	{
		// initialize strategies
		strategies.put("ConstantValue", new ConstantValueStrategy());
		strategies.put("Code", new CodeStrategy(constantPoolSource));
		strategies.put("LineNumberTable", new LineNumberTableStrategy());
		strategies.put("LocalVariableTable", new LocalVariableTableStrategy());
		strategies.put("StackMapTable", new StackMapTableStrategy());
	}

	private ConstantPoolInfo[] constantPool;

	public AttributeInfoReader(ConstantPoolInfo[] constantPool)
	{
		this.constantPool = constantPool;
		AttributeInfoReader.constantPoolSource.setValue(constantPool);
	}

	@Override
	public AttributeInfo readData(DataInputStream in) throws IOException
	{
		int attributeNameIndex = in.readUnsignedShort();
		long attributeLength = in.readInt() & 0xFFFFFFFFL;

		ConstantPoolInfo info = constantPool[attributeNameIndex];
		String attributeName = null;
		if (info.getTag() == ConstantPoolTag.UTF8)
		{
			attributeName = ((UTF8InfoConstant) info).getValue();
		}
		else
		{
			throw new IOException(
					"the classfile seems to be corrupted, since the attribute_name_index does not refer to a CONSTANT_Utf8_info structure!");
		}

		AttributeInfoReaderStrategy strategy = strategies.get(attributeName);

		AttributeInfo data = null;
		if (strategy == null)
		{
			logger.warn("No strategy for {} defined: {} bytes get skipped!", attributeName, attributeLength);
			in.skip(attributeLength); // try to read the next attribute
		}
		else
		{
			constantPoolSource.setValue(constantPool);
			data = strategy.readData(in, attributeNameIndex, attributeLength);
		}

		return data;
	}

}
