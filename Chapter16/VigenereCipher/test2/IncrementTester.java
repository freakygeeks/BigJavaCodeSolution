public class IncrementTester
{
	public static void main (String[] args)
	{
		String text = "zacharyrafael";
		String result = "";
		
		for (int j = 0; j < text.length(); j++)
		{
			char c = text.charAt(j);
			result = result + c;
			//System.out.println ("Output j++ : " + result);
			
			j = (j++ + 1) % text.length();
			System.out.println ("j = j++ : " + j);
		}
		
		System.out.println();
		
		for (int j = 0; j < text.length(); ++j)
		{
			char c = text.charAt(j);
			result = result + c;
			//System.out.println ("Output ++j: " + result);
			
			j = ++j % text.length();
			System.out.println ("j = ++j : " + j);
		}
	}
}