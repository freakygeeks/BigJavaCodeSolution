//Chapter6 -  Example 6.3.2
public class TaxReturn
{
	public static final int SINGLE = 1;
	public static final int MARRIED = 2;
	
	private static final double RATE1 = 0.15;
	private static final double RATE2 = 0.28;
	private static final double RATE3 = 0.31;
	
	private static final double SINGLE_BRACKET1 = 21450;
	private static final double SINGLE_BRACKET2 = 51900;
	
	private static final double MARRIED_BRACKET1 = 35800;
	private static final double MARRIED_BRACKET2 = 86500;	
	
	private double income;
	private int status;
		
	public TaxReturn (double anIncome, int aStatus)
	{
	income = anIncome;
	status = aStatus;
	}
	
	public double getTax()
	{
	double tax = 0;
	
	if (status == SINGLE)
	{
		if (income <= SINGLE_BRACKET1)
			tax = RATE1*income;
		else if (income <= SINGLE_BRACKET2)
			tax = RATE1*SINGLE_BRACKET1 + RATE2*(income-SINGLE_BRACKET1);
		else 
			tax = RATE1*SINGLE_BRACKET1 + RATE2*(SINGLE_BRACKET2-SINGLE_BRACKET1) + RATE3*(income-SINGLE_BRACKET2);
	}
	
	if (status == MARRIED)
	{
		if (income <= MARRIED_BRACKET1)
			tax = RATE1*income;
		else if (income <= MARRIED_BRACKET2)
			tax = RATE1*MARRIED_BRACKET1 + RATE2*(income-MARRIED_BRACKET1);
		else 
			tax = RATE1*MARRIED_BRACKET1 + RATE2*(MARRIED_BRACKET2-MARRIED_BRACKET1) + RATE3*(income-MARRIED_BRACKET2);
	}
	return tax;
	}
}
	