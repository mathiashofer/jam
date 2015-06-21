package at.mhofer.jam.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum AccessFlag
{
	
	ACC_PUBLIC(0x0001),
	ACC_PRIVATE(0x0002),
	ACC_PROTECTED(0x0004),
	ACC_STATIC(0x0008),
	ACC_FINAL(0x0010),
	ACC_VOLATILE(0x0040),
	ACC_TRANSIENT(0x0080),
	ACC_SYNTHETIC(0x1000),
	ACC_ENUM(0x4000);
	
	private final int value;
	
	private static final Map<Integer, AccessFlag> FLAG_MAP = new HashMap<Integer, AccessFlag>();
	
	static
	{
		for (AccessFlag flag : AccessFlag.values())
		{
			FLAG_MAP.put(flag.value, flag);
		}
	}
	
	private AccessFlag(int value) { this.value = value; }
		
	public int value() { return value; }
	
	public static AccessFlag fromValue(int value)
	{
		return FLAG_MAP.get(value);
	}
	
	/**
	 * @param bytes
	 * @return all flags which are masked in the given u2
	 */
	public static AccessFlag[] fromBytes(int bytes)
	{
		List<AccessFlag> flags = new ArrayList<AccessFlag>();
		
		for (AccessFlag flag : FLAG_MAP.values())
		{
			if ((bytes & flag.value) != 0)
			{
				flags.add(flag);
			}
		}
		
		return flags.toArray(new AccessFlag[0]);
	}

}
