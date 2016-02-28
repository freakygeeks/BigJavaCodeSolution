//Chapter3
public class CashRegisterNextTester
{
	public static void main (String[] args)
	{
	CashRegisterNext reg = new CashRegisterNext();
	reg.enterPayment(50);
	reg.recordPurchase(30);
	
	double register = reg.getChange();
	
	System.out.println (register);
	}
}