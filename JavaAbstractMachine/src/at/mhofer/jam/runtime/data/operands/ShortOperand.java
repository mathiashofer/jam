package at.mhofer.jam.runtime.data.operands;

public class ShortOperand extends Operand
{

	private short value;

	public ShortOperand(short value)
	{
		this.value = value;
	}

	@Override
	public ShortOperand add(Operand operand)
	{
		return new ShortOperand((short) (value + operand.getValue().shortValue()));
	}

	@Override
	public ShortOperand sub(Operand operand)
	{
		return new ShortOperand((short) (value - operand.getValue().shortValue()));
	}

	@Override
	public ShortOperand mul(Operand operand)
	{
		return new ShortOperand((short) (value * operand.getValue().shortValue()));
	}

	@Override
	public ShortOperand div(Operand operand)
	{
		return new ShortOperand((short) (value / operand.getValue().shortValue()));
	}

	@Override
	public ShortOperand rem(Operand operand)
	{
		return new ShortOperand((short) (value % operand.getValue().shortValue()));
	}

	@Override
	public ShortOperand neg()
	{
		return new ShortOperand((short) -value);
	}

	@Override
	public Short getValue()
	{
		return value;
	}

	@Override
	public Operand add(Number operand)
	{
		return new ShortOperand((short) (value + operand.shortValue()));
	}

	@Override
	public Operand sub(Number operand)
	{
		return new ShortOperand((short) (value - operand.shortValue()));
	}

	@Override
	public Operand mul(Number operand)
	{
		return new ShortOperand((short) (value * operand.shortValue()));
	}

	@Override
	public Operand div(Number operand)
	{
		return new ShortOperand((short) (value / operand.shortValue()));
	}

	@Override
	public Operand rem(Number operand)
	{
		return new ShortOperand((short) (value % operand.shortValue()));
	}
}
