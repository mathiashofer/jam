package at.mhofer.jam.util;

import java.lang.reflect.Field;

import at.mhofer.jam.runtime.OpCodes;

public class OpCodeUtil
{

	private static Field[] opcFields = OpCodes.class.getDeclaredFields();

	public static String nameByValue(int opCode)
	{
		String name = null;
		for (Field f : opcFields)
		{
			try
			{
				int value = (int) f.get(Integer.class);
				
				if (value == opCode)
				{
					name = f.getName();
				}
			}
			catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		return name;
	}
	
}
