import java.util.Arrays;

public class StringArrayToChar
{
	public static void main (String[] args)
	{
		int row = 0;
		int col = 0;
		String LETTERS = "abcdefghijklmnopqrstuvwxyz";
		String keyInput = "tuvwxyzabcdefghijklmnopqrsijklmnopqrstuvwxyzabcdefghghijklmnopqrstuvwxyzabcdef";
		String textInput = "javastyleguidelines";
		int numKey = keyInput.length()+1;
		int numText = textInput.length()+1;
		char[] key = new char[numKey];
		char[] text = new char[numText];
		char textOutput = '\0';
		
		System.out.println("Letter in string : " + LETTERS);
		for (int i = 0; i < keyInput.length(); i++)
		{
			col++;
			char keyOutput = keyInput.charAt(i);
			key[col] = keyOutput;
			System.out.print(key[col]);
		}
		System.out.println();
		
		for (int j = 0; j < textInput.length(); j++)
		{
			row++;

			textOutput = textInput.charAt(j);
			
			int y = LETTERS.indexOf(textOutput);
			
			text[row] = textOutput;
			System.out.print(row + " : " + text[row] + " : " + keyInput.charAt(y) + " : " + y + " : ");
			System.out.println();
		}
		System.out.println();
		
	}
}