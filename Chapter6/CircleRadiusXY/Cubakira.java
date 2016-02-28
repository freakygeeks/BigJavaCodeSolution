//Chapter6 -  Exercise 6.5
public class Cubakira
{
	private double a;
	private double b;
	private double c;
	private String A1;
	private String B1;
	private String C1;
	
	public Cubakira()
	{
	a = 0;
	b = 0;
	c = 0;
	A1 = "Congratulations!";
	B1 = "You missed a little!";
	C1 = "You missed a lot!";
	}
	
	public void enterNum(double a1, double b1)
	{
	this.a = this.a + a1;
	this.b = this.b + b1;
	}

	public void getString()
	{
	this.A1 = this.A1;
	this.B1 = this.B1;
	this.C1 = this.C1;
	}
	
	public String getOrder()
	{
	if (10 <= this.a && this.a <= 100)
		{
		if (10 <= this.b && this.b <= 100)
		{
			return this.A1;
		}
		else
			return this.B1;
		}
	else
		return this.C1;
	}
}