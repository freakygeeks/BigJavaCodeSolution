//Chapter6 - Project P6.1

public class CombinationLock
{
	private static final String string1 = "F";
	private static final String string2 = "A";
	private static final String string3 = "K";
	
	private String str1;
	private String str2;
	private String str3;
	private int num;
	
	public CombinationLock(String s1, String s2, String s3)
	{
	str1 = s1;
	str2 = s2;
	str3 = s3;	
	num = 0;
	}
	
	public String getLock()
	{
	num++;
	String a = " ";
	
	if (str1.equals(string1) && str2.equals(string2) && str3.equals(string3))
		a = "The dial is correct. Lock is open!";
	else
		a = "The dial is incorrect. Please try again.";
	
	return a;
	}
	
	public void isOpen()
	{
	num = 0;
	}
}
	