//Chapter4 - Exercise P4.1
public class CashRegisterTester
{
	public static void main (String[] args)
	{
	CashRegister reg = new CashRegister();
	
	reg.recordPurchase(0.75);
	reg.recordPurchase(1.50);
	reg.enterPayment(2, 0, 5, 0, 0);
	System.out.println ("Change = " + reg.giveChange());
	
	reg.recordPurchase(2.25);
	reg.recordPurchase(19.25);
	reg.enterPayment(23, 2, 0, 0, 0);
	System.out.println ("Change = " + reg.giveChange());
	}
}