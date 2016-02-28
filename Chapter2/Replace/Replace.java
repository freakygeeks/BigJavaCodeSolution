//Chapter2
public class Replace
{
	public static void main (String[] args)
	{
	String river = "Sungai Pahang";
	String bigriver = river.replace ("Sung", "Laut");
	int num = bigriver.length();
	
	System.out.println (bigriver);
	System.out.println (river.replace ("Sung", "Laut"));
	System.out.print (river.replace ("Sung", "Laut").length());
	}
}