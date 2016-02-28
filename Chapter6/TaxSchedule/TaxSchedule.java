//Chapter6 - Project P6.2

public class TaxSchedule
{
	public static final int S = 1;
	public static final int MJ = 2;
	public static final int MS = 3;
	public static final int H = 4;
	
	private int st;
	private double in;
	
	public TaxSchedule(int status, double income)
	{
	st = status;
	in = income;
	}
	
	public double getTax()
	{
	double tax = 0;
	
	if (st == S)
		{
		if (in == 25200 && in < 25250)
			tax = 3338;
		else if (in == 25250 && in < 25300)
			tax = 3345;
		else if (in == 25300 && in < 25350)
			tax = 3353;
		else if (in == 25350 && in < 25400)
			tax = 3360;
		}
	
	else if (st == MJ)
		{
		if (in == 25200 && in < 25250)
			tax = 2891;
		else if (in == 25250 && in < 25300)
			tax = 2899;
		else if (in == 25300 && in < 25350)
			tax = 2906;
		else if (in == 25350 && in < 25400)
			tax = 2914;
		}
		
	else if (st == MS)
		{
		if (in == 25200 && in < 25250)
			tax = 3338;
		else if (in == 25250 && in < 25300)
			tax = 3345;
		else if (in == 25300 && in < 25350)
			tax = 3353;
		else if (in == 25350 && in < 25400)
			tax = 3360;
		}
		
	else if (st == H)
		{
		if (in == 25200 && in < 25250)
			tax = 3146;
		else if (in == 25250 && in < 25300)
			tax = 3154;
		else if (in == 25300 && in < 25350)
			tax = 3161; 
		else if (in == 25350 && in < 25400)
			tax = 3169;
		}

	return tax;
	}
}