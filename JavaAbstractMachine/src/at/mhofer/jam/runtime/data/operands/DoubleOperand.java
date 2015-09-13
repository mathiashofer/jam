package at.mhofer.jam.runtime.data.operands;

public class DoubleOperand extends Operand
{
	private double value;

	public DoubleOperand(double value)
	{
		this.value = value;
	}

	@Override
	public DoubleOperand add(Operand operand)
	{
		return new DoubleOperand(value + operand.getValue().doubleValue());
	}

	@Override
	public DoubleOperand sub(Operand operand)
	{
		return new DoubleOperand(value - operand.getValue().doubleValue());
	}

	@Override
	public DoubleOperand mul(Operand operand)
	{
		return new DoubleOperand(value * operand.getValue().doubleValue());
	}

	@Override
	public DoubleOperand div(Operand operand)
	{
		return new DoubleOperand(value / operand.getValue().doubleValue());
	}

	@Override
	public DoubleOperand rem(Operand operand)
	{
		return new DoubleOperand(value % operand.getValue().doubleValue());
	}

	@Override
	public DoubleOperand neg()
	{
		return new DoubleOperand(-value);
	}

	@Override
	public Double getValue()
	{
		return value;
	}

	@Override
	public Operand add(Number operand)
	{
		return new DoubleOperand(value + operand.doubleValue());
	}

	@Override
	public Operand sub(Number operand)
	{
		return new DoubleOperand(value - operand.doubleValue());
	}

	@Override
	public Operand mul(Number operand)
	{
		return new DoubleOperand(value * operand.doubleValue());
	}

	@Override
	public Operand div(Number operand)
	{
		return new DoubleOperand(value / operand.doubleValue());
	}

	@Override
	public Operand rem(Number operand)
	{
		return new DoubleOperand(value % operand.doubleValue());
	}
}
