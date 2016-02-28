//Chapter4
public class StampMachine
{
	public static final double FIRST_CLASS_STAMP_PRICE = 0.37;
	private double money;
	
	public StampMachine()
	{
	money = 0;
	}
	
	public void insert (double amount)
	{
	this.money = this.money + amount;
	}
	
	public int giveFirstClassStamp()
	{
	int firstClassStamp = (int)(money/FIRST_CLASS_STAMP_PRICE);
	money = money - (firstClassStamp*FIRST_CLASS_STAMP_PRICE);
	return firstClassStamp;
	}
	
	public int givePennyStamp()
	{
	int pennyStamp = (int)Math.round(100*money);
	money = 0;
	return pennyStamp;
	}
}