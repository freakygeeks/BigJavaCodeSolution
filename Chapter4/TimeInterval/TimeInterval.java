//Chapter4 - Exercise 4.14
public class TimeInterval
{
	public static final int MIN = 60;
	
	private int firstTime;
	private int secondTime;
	private int num1;
	private int num2;
	
	public TimeInterval()
	{
	firstTime = 0;
	secondTime = 0;
	}
	
	public void addTime(int first, int second)
	{
	this.firstTime = this.firstTime + first;
	this.secondTime = this.secondTime + second;
	}
	
	public int getHourFirst()
	{
	int num1 = 0;
		if(firstTime>0) //input 1730
		{
		num1 = firstTime%100; //get minute = 30
		firstTime = firstTime/100; //get hours = 17
		}
		
	int num1a = (int)(firstTime*MIN); //7*60 = 1020
	int num1b = (int)(num1a+num1); //1020+30
	this.firstTime = (int)(num1b);
	return firstTime; //1050
	}
	
	public int getHourSecond()
	{
	int num2 = 0;
		if(secondTime>0) //input 900
		{
		num2 = secondTime%100; //get minute = 00
		secondTime = secondTime/100; //get hour = 9
		}
	
	int num2a = (int)(secondTime*MIN); //9*60 = 540
	int num2b = (int)(num2a+num2); //540+0 = 540
	this.secondTime = (int)(num2b);
	return this.secondTime; //540
	}
	
	public int getHour()
	{
	int hour = Math.abs(firstTime-secondTime); //(1050-540) = 510
	int hour1 = (int)(hour/MIN); // 510/60 = 8
	return hour1; //8
	}
	
	public int getMinute()
	{
	int minute = Math.abs(firstTime-secondTime); //(1050-540) = 510
	int minute1 = (int)(minute%MIN); //510%60 = 30
	return minute1; //30
	}	
}