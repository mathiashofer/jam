package at.mhofer.jam.runtime.data;

import at.mhofer.jam.data.ClassFile;
import at.mhofer.jam.data.methods.MethodInfo;
import at.mhofer.jam.runtime.data.operands.ReferenceOperand;

public final class MethodArea
{

	private static TupleKeyHashMap<Integer, Integer, MethodInfo> methodsPerClass = new TupleKeyHashMap<Integer, Integer, MethodInfo>();

	public static MethodInfo getMethodPerClass(ReferenceOperand clazz, ReferenceOperand method)
	{
		return methodsPerClass.get(clazz.getValue(), method.getValue());
	}

	public static void storeClass(ClassFile clazz)
	{
		for (MethodInfo method : clazz.getMethods())
		{
			methodsPerClass.put(clazz.getThisClass(), method.getNameIndex(), method);
		}
	}
}
