//Chapter4 - Exercise 4.18
public class EasterSunday
{
	private int year;
	private int month;
	private int date;
	
	public EasterSunday()
	{
	year = 0;
	month = 0;
	date = 0;
	}
	
	public void getYear (int digit)
	{
	this.year = this.year + digit;
	}
	
	public int getEasterSunday()
	{
	int y = (int)(year); //2001
	int a = (int)(y%19); //6
	int b = (int)(y/100); //20
	int c = (int)(y%100); //1
	int d = (int)(b/4); //5
	int e = (int)(b%4); //0
	int g = (int)((8*b+13)/25); //6
	int h = (int)((19*a+b-d-g+15)%30); //18
	int j = (int)(c/4); //0
	int k = (int)(c%4);
	int m = (int)((a+11*h)/319); //0
	int r = (int)((2*e+2*j-k-h+m+32)%7); //6
	int n = (int)((h-m+r+90)/25); //4
	int p = (int)((h-m+r+n+19)%32); //15
	
	this.month = this.month + n;
	this.date = this.date + p;
	
	return y;
	}
	
	public String getEasterSundayMonth()
	{
	String monthName = "Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec ";
	int startIndex = (int)((month-1)*4);
	int endIndex = (int)(startIndex+4);
	
	return monthName.substring(startIndex,endIndex);
	//return this.month;
	}
	
	public int getEasterSundayDay()
	{
	return this.date;
	}
}