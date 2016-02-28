//Chapter3
public class CashRegisterThisTester
{
	public static void main (String[] args)
	{
	CashRegisterThis reg = new CashRegisterThis();
	reg.enterPayment(50);
	reg.recordPurchase(30);
	
	double register = reg.getChange();
	
	System.out.println (register);
	}
}