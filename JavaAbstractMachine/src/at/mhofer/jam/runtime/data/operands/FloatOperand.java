package at.mhofer.jam.runtime.data.operands;

public class FloatOperand extends Operand
{

	private float value;

	public FloatOperand(float value)
	{
		this.value = value;
	}

	@Override
	public FloatOperand add(Operand operand)
	{
		return new FloatOperand(value + operand.getValue().floatValue());
	}

	@Override
	public FloatOperand sub(Operand operand)
	{
		return new FloatOperand(value - operand.getValue().floatValue());
	}

	@Override
	public FloatOperand mul(Operand operand)
	{
		return new FloatOperand(value * operand.getValue().floatValue());
	}

	@Override
	public FloatOperand div(Operand operand)
	{
		return new FloatOperand(value / operand.getValue().floatValue());
	}

	@Override
	public FloatOperand rem(Operand operand)
	{
		return new FloatOperand(value % operand.getValue().floatValue());
	}

	@Override
	public FloatOperand neg()
	{
		return new FloatOperand(-value);
	}

	@Override
	public Float getValue()
	{
		return value;
	}


	@Override
	public Operand add(Number operand)
	{
		return new FloatOperand(value + operand.floatValue());
	}

	@Override
	public Operand sub(Number operand)
	{
		return new FloatOperand(value - operand.floatValue());
	}

	@Override
	public Operand mul(Number operand)
	{
		return new FloatOperand(value * operand.floatValue());
	}

	@Override
	public Operand div(Number operand)
	{
		return new FloatOperand(value / operand.floatValue());
	}

	@Override
	public Operand rem(Number operand)
	{
		return new FloatOperand(value % operand.floatValue());
	}
}
