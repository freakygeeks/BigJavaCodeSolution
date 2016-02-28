//Chapter2 - Project 2.1
import java.util.GregorianCalendar;
import java.util.Calendar;

public class MyCalendar
{
	public static void main (String[] args)
	{
	//to get date of today
	GregorianCalendar cal = new GregorianCalendar();
	int day1 = cal.get(Calendar.DAY_OF_MONTH);
	int month1 = cal.get(Calendar.MONTH);
	int year1 = cal.get(Calendar.YEAR);
	int week1 = cal.get(Calendar.DAY_OF_WEEK);
	//to print date of today
	System.out.println ("<---------------TODAY DATE-------------->");
	System.out.println ("Today date is : " + day1 + "/" + (month1+1) + "/" + year1);
	System.out.println ("Today week is : " + week1 + "\n");
	
	//to get date after 100 days from today
	cal.add(Calendar.DAY_OF_MONTH,100);
	int day2 = cal.get(Calendar.DAY_OF_MONTH);
	int month2 = cal.get(Calendar.MONTH);
	int year2 = cal.get(Calendar.YEAR);
	int week2 = cal.get(Calendar.DAY_OF_WEEK);
	//to print date after 100 days from today
	System.out.println ("<-----------100 DAYS AFTER-------------->");
	System.out.println ("After 100 days, date is : " + day2 + "/" + (month2+1) + "/" + year2);
	System.out.println ("After 100 days, week is : " + week2 + "\n");
	
	//to get the weekday of your birthday
	GregorianCalendar birth = new GregorianCalendar(1985, Calendar.MAY + 1, 22);
	int day3 = birth.get(Calendar.DAY_OF_MONTH);
	int month3 = birth.get(Calendar.MONTH);
	int year3 = birth.get(Calendar.YEAR);
	int week3 = birth.get(Calendar.DAY_OF_WEEK);
	//to print weekday of your birthday
	System.out.println ("<---------------WEEK OF BIRTH----------->");
	System.out.println ("Birthday date is : " + day3 + "/" + month3 + "/" + year3);
	System.out.println ("The weekday of birthday is : " + week3 + "\n");
	//to get date after 10000 days of birthday
	birth.add(Calendar.DAY_OF_MONTH,10000);
	int day4 = birth.get(Calendar.DAY_OF_MONTH);
	int month4 = birth.get(Calendar.MONTH);
	int year4 = birth.get(Calendar.YEAR);
	//to print date after 10000 days of birthday
	System.out.println ("<----------10000 DAYS AFTER BIRTH------------->");
	System.out.println ("After 10000 days of birthday, date is : " + day4 + "/" + month4 + "/" + year4);
	}
}