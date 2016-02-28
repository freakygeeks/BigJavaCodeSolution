//Chapter 6 - Exercise P6.10

public class Lexi
{
	private String st1;
	private String st2;
	private String st3;
	private String st4;
	
	public Lexi (String letter1, String letter2, String letter3, String letter4)
	{
	st1 = letter1;
	st2 = letter2;
	st3 = letter3;
	st4 = letter4;
	}
	
	public String getMin()
	{
	String x = " ";
	
	int a1 = st1.compareTo(st2);
	int a2 = st1.compareTo(st3);
	int a3 = st1.compareTo(st4);
	
	System.out.println ("String1 compare to String2 :" + st1.compareTo(st2)); // return st2
	System.out.println ("String1 compare to String3 :" + st1.compareTo(st3)); // return st3
	System.out.println ("String1 compare to String4 :" + st1.compareTo(st4)); // return st4
	
	if (a2 > a1 && a1 < a3)
		x = st2;
	else if (a1 > a2 && a2 < a3)
		x = st3; 
	else if (a1 > a3 && a3 < a2)
		x = st4; 
	else
		x = st1;
		
	return x;
	}
	
	public String getMax()
	{
	String y = " ";
	
	int a1 = st1.compareTo(st2);
	int a2 = st1.compareTo(st3);
	int a3 = st1.compareTo(st4);
	
	System.out.println ("String1 compare to String2 :" + st1.compareTo(st2)); // return st2
	System.out.println ("String1 compare to String3 :" + st1.compareTo(st3)); // return st3
	System.out.println ("String1 compare to String4 :" + st1.compareTo(st4)); // return st4
	
	if (a2 < a1 && a1 > a3)
		y = st2;
	else if (a1 < a2 && a2 > a3)
		y = st3;
	else if (a2 < a3 && a3 > a2)
		y = st4;
	else
		y = st1;
		
	return y;
	}
}