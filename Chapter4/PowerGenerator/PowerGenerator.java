//Chapter4 - Exercise P4.3
public class PowerGenerator
{
	public static final int POWER = 10;
	
	private long num;
	
	public PowerGenerator()
	{
	num = 1;
	}
	
	public void Generate ()
	{
	this.num = this.num;
	}
	
	public long nextGenerate ()
	{
	this.num = this.num*POWER;
	return this.num;
	}
	
	public void reset()
	{
	num = 1;
	}
}