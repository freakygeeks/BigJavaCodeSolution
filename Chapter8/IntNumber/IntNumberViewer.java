//Chapter8 - Exercise P8.10

public class IntNumberViewer
{
	public static void main (String[] args)
	{
	IntNumber calc = new IntNumber();
	
	calc.addNum(1);
	calc.addNum(4);
	calc.addNum(9);
	calc.addNum(16);
	calc.addNum(9);
	calc.addNum(7);
	calc.addNum(4);
	calc.addNum(9);
	calc.addNum(11);
	
	System.out.println("Numbers are : " + calc.toInteger());
	}
}