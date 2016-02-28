//Chapter4
public class OperationTester
{
	public static void main (String[] args)
	{
	Operation op = new Operation();
	op.addCalc(200, 40, 3, 0, 0);
	
	System.out.println ("Dollars = " + op.getDollars() + " Cents = " + op.getCents());
	}
}
	