//Chapter 6 - Exercise P6.14

public class TwoFloatNum
{
	private float n1;
	private float n2;
	
	public TwoFloatNum (float num1, float num2)
	{
	n1 = num1;
	n2 = num2;
	}
	
	public String getFloat()
	{
	String a = " ";
	
	float b1 = (float) (Math.round(n1*100.0f)/100.0f);
	System.out.println ("Rounding first float : " + b1);
	
	float b2 = (float) (Math.round(n2*100.0f)/100.0f);
	System.out.println ("Rounding first float : " + b2);
	
	if (b1 == b2)
		a = "They are the same when rounded to two decimal places";
	else if (b1 != b2)
		a = "The are different";
	else
		System.out.println ("Bad input!");
	
	return a;
	}
}