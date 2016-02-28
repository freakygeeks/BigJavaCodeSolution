//Chapter4 - Exercise P4.2
public class CashRegisterTesterSeparate
{
	public static void main(String[] args)
	{
	CashRegisterSeparate reg = new CashRegisterSeparate();
	
	reg.recordPurchase(20.37);
	reg.recordPurchase(10.37);
	reg.enterDollar (40);
	reg.enterQuarter (2);
	
	System.out.println ("Total change is : " + reg.giveChange());
	System.out.println ("Total numbers of item sale are : " + reg.getItemCount());
	
	reg.reset();
	}
}