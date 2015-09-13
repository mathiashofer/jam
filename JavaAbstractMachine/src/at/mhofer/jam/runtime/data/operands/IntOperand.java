package at.mhofer.jam.runtime.data.operands;

public class IntOperand extends Operand
{
	private int value;

	public IntOperand(int value)
	{
		this.value = value;
	}

	@Override
	public IntOperand add(Operand operand)
	{
		return new IntOperand(value + operand.getValue().intValue());
	}

	@Override
	public IntOperand sub(Operand operand)
	{
		return new IntOperand(value - operand.getValue().intValue());
	}

	@Override
	public IntOperand mul(Operand operand)
	{
		return new IntOperand(value * operand.getValue().intValue());
	}

	@Override
	public IntOperand div(Operand operand)
	{
		return new IntOperand(value / operand.getValue().intValue());
	}

	@Override
	public IntOperand rem(Operand operand)
	{
		return new IntOperand(value / operand.getValue().intValue());
	}

	@Override
	public IntOperand neg()
	{
		return new IntOperand(-value);
	}

	@Override
	public Integer getValue()
	{
		return value;
	}

	@Override
	public Operand add(Number operand)
	{
		return new IntOperand(value + operand.intValue());
	}

	@Override
	public Operand sub(Number operand)
	{
		return new IntOperand(value - operand.intValue());
	}

	@Override
	public Operand mul(Number operand)
	{
		return new IntOperand(value * operand.intValue());
	}

	@Override
	public Operand div(Number operand)
	{
		return new IntOperand(value / operand.intValue());
	}

	@Override
	public Operand rem(Number operand)
	{
		return new IntOperand(value % operand.intValue());
	}

}
