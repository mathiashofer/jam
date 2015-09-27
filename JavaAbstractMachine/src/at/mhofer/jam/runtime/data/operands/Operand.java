package at.mhofer.jam.runtime.data.operands;

import at.mhofer.jam.runtime.data.DataType;

/**
 * The implementations of Operand have to be immutable
 * 
 * @author Mathias
 *
 */
public abstract class Operand implements DataType, Comparable<Operand>
{

	public abstract Operand add(Operand operand);
	
	public abstract Operand add(Number operand);

	public abstract Operand sub(Operand operand);
	
	public abstract Operand sub(Number operand);

	public abstract Operand mul(Operand operand);
	
	public abstract Operand mul(Number operand);

	public abstract Operand div(Operand operand);
	
	public abstract Operand div(Number operand);

	public abstract Operand rem(Operand operand);
	
	public abstract Operand rem(Number operand);
	
	public abstract Operand neg();
	
	public boolean eq(Operand op)
	{
		return this.compareTo(op) == 0;
	}
	
	public boolean neq(Operand op)
	{
		return this.compareTo(op) != 0;
	}
	
	public boolean ge(Operand op)
	{
		return this.compareTo(op) >= 0;
	}
	
	public boolean gt(Operand op)
	{
		return this.compareTo(op) > 0;
	}
	
	public boolean le(Operand op)
	{
		return this.compareTo(op) <= 0;
	}
	
	public boolean lt(Operand op)
	{
		return this.compareTo(op) < 0;
	}
	
	public abstract Number getValue();
	
	@Override
	public int compareTo(Operand op)
	{
		/*
		 * Use the double value for comparison, because its the biggest available datatype.
		 */
		return (int) (getValue().doubleValue() - op.getValue().doubleValue());
	}

	@Override
	public String toString()
	{
		return "Operand [value=" + getValue() + "]";
	}

}
