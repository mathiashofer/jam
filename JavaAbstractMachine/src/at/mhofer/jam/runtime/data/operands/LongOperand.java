package at.mhofer.jam.runtime.data.operands;

public class LongOperand extends Operand
{
	
	public static final LongOperand ZERO = new LongOperand(0);
	public static final LongOperand ONE = new LongOperand(1);

	private long value;

	public LongOperand(long value)
	{
		this.value = value;
	}

	@Override
	public LongOperand add(Operand operand)
	{
		return new LongOperand(value + operand.getValue().longValue());
	}

	@Override
	public LongOperand sub(Operand operand)
	{
		return new LongOperand(value - operand.getValue().longValue());
	}

	@Override
	public LongOperand mul(Operand operand)
	{
		return new LongOperand(value * operand.getValue().longValue());
	}

	@Override
	public LongOperand div(Operand operand)
	{
		return new LongOperand(value / operand.getValue().longValue());
	}

	@Override
	public LongOperand rem(Operand operand)
	{
		return new LongOperand(value % operand.getValue().longValue());
	}

	@Override
	public LongOperand neg()
	{
		return new LongOperand(-value);
	}

	@Override
	public Long getValue()
	{
		return value;
	}

	@Override
	public Operand add(Number operand)
	{
		return new LongOperand(value + operand.longValue());
	}

	@Override
	public Operand sub(Number operand)
	{
		return new LongOperand(value - operand.longValue());
	}

	@Override
	public Operand mul(Number operand)
	{
		return new LongOperand(value * operand.longValue());
	}

	@Override
	public Operand div(Number operand)
	{
		return new LongOperand(value / operand.longValue());
	}

	@Override
	public Operand rem(Number operand)
	{
		return new LongOperand(value % operand.longValue());
	}
	
}
