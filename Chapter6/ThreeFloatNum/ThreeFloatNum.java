//Chapter 6 -Exercise P6.4

public class ThreeFloatNum
{
	private double num1;
	private double num2;
	private double num3;
	
	public ThreeFloatNum()
	{
	num1 = 0;
	num2 = 0;
	num3 = 0;
	}
	
	public void enterNumber(double no1, double no2, double no3)
	{
	this.num1 = this.num1 + no1;
	this.num2 = this.num2 + no2;
	this.num3 = this.num3 + no3;
	}
	
	public double getOrderLowest()
	{
	if (this.num2 > this.num1 && this.num1 < this.num3)
		{
		return this.num1;
		}
	else if (this.num1 > this.num2 && this.num2 < this.num3)
		{
		return this.num2;
		}
	else
		return this.num3;
	}
	
	public double getOrderMiddle()
	{
	if (this.num2 > this.num1 && this.num1 > this.num3)
		{
		return this.num1;
		}
	else if (this.num2 < this.num1 && this.num1 < this.num3)
		{
		return this.num1;
		}
	else if (this.num1 > this.num2 && this.num2 > this.num3)
		{
		return this.num2;
		}
	else if (this.num1 < this.num2 && this.num2 < this.num3)
		{
		return this.num2;
		}
	else
		return this.num3;
	}
	
	public double getOrderHighest()
	{
	if (this.num2 < this.num1 && this.num1 > this.num3)
		{
		return this.num1;
		}
	else if (this.num1 < this.num2 && this.num2 > this.num3)
		{
		return this.num2;
		}
	else
		return this.num3;
	}
}