import java.util.Scanner;

/**
 * The Ceasar code is really easy to decript. There are only 26 different keys
 * and frequency studies can decipher a coded message quite rapidly.
 * In English, as example, the letter "e" is the most commonly used letter followed
 * by 'a'.  As soon as the encrypted 'e' or 'a' is identified it is quite easy to
 * apply the same shift to the other letters of the message. But if the message is very short 
 * and screw up the normal frequency of letters like in: "Zebras run in zig zags from
 * Zambia to Zanzibar" :-)
 * 
 * If you use the GUI I wrote for the Ceasar code, it is quite easy to enter the coded
 * message and then try the 26 possible shifts by cliking on the different JRadioButtons 
 * 
 * Derived from the Ceasar code is the Vigenere's square. His code was developped in the
 * XVII century. Actualy the algorithm has been described in a book published
 * by Giovan Battista Bellaso in 1563 but is now well known as the Vigener's cypher.
 * This cypher was reputated 100% safe until the XIX century.
 * 
 * The whole idea is to use like the Ceasar code a shift of letter in the Alphabet but to change 
 * the number of shifted letter for each letter of the message.  This would completly, at least they thought 
 * at that time, the frequency analysis.
 * 
 * So to cypher we use the so called Vigenere's square
 * 
 * A - ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * B - BCDEFGHIJKLMNOPQRSTUVWXYZA
 * C - CDEFGHIJKLMNOPQRSTUVWXYZAB
 * D - DEFGHIJKLMNOPQRSTUVWXYZABC
 * E - EFGHIJKLMNOPQRSTUVWXYZABCD
 * ...
 * H - GHIJKLMNOPQRSTUVWXYZABCDED
 * ...
 * Y - YZABCDEFGHIJKLMNOPQRSTUVWX
 * Z - ZABCDEFGHIJKLMNOPQRSTUVWXY
 *
 * In the Ceasar code, the key is the number of letters we shift the original letter to produce the
 * coded message.
 * In the Vigenere's cypher the key is a word that is repeat over the message to encrypt.
 * Lets assume the key is "CHARLIE" and the message is "tutorials at dic"
 * 
 * We write the the key over the message
 * 
 * CHARLIECHARLIECH
 * tutorials at dic
 * 
 * Now to encode the message we use:
 * - the shiftet alphabet at row C for the first letter so  T becomes V
 * - the shifted alphabet ar row H for the second letter so U becomes A
 * - the shifted alphabet at row A for the third letter so  T stays   T
 * and so on
 * 
 * P.S.
 * If the key is A or AA or AAA or any multiple of A there is no encryption performed
 * Evidently the longuest the Key the less repetitions (cycles) you will have
 */
public class Vigenere {

	// the key used by this Vigenere object
	private String key;
	
	/**
	 * contructor that receives the key as parameter
	 */
	public Vigenere(String key) {
		// call the standard method to set up the key
		setKey(key);
	}
	
	/**
	 * The method to set up/change the key
	 */
	public void setKey(String key) {
		// empty key ignore it
		if(key == null) {
			this.key = "";
			return;
		}
		
		// keep only the letters in the key and keep them uppercase
		char[] digit = key.toUpperCase().toCharArray();
		// use a stringBuilder to create the the keyString
		StringBuilder sb = new StringBuilder(digit.length);
		for(char c : digit) {
			if(c >= 'A' && c <= 'Z')
				sb.append(c);
		}
		
		// save our key
		this.key = sb.toString();
	}
	
	/**
	 * Encode a message according to the key already registered
	 */
	public String encode(String clear) {
		// ignore if null
		if(clear == null)
			return "";
		// ignore if key length == 0
		if(key.length() == 0)
			return clear.toUpperCase();
		// by convention in the cryptology world all original messages are in lower case
		// and coded messages in uppercase
		// so let us put the original message in lower cases
		// convert the original message into an array of char
		// into which converted character will be put later
		char[] digit = clear.toLowerCase().toCharArray();
		
		// build a string with the repeated key at least the size of our message
		String longKey = key;
		while(longKey.length() < clear.length())
			longKey += key;
		
		// pass through all input digits to convert them
		for(int i = 0; i < digit.length; i++) {
			// if they are not between 'a' and 'z' just ignore them (message has been translated to lowercase)
			if(digit[i] < 'a' || digit[i] > 'z') 
				continue;
			
			// find out by how much we shift (like in a Ceasar code)
			char offset = longKey.charAt(i);
			// subtract 'A' for it for the number of shift
			int nbShift = offset - 'A';
			// convert the digit to uppercase (as we mentionned this is a standard cryptographic convention)
			digit[i] = Character.toUpperCase(digit[i]);
			// applied the shift to it
			digit[i] += nbShift;
			// wrap around if over 'Z'
			if(digit[i] > 'Z') {
				digit[i] -= 'Z';
				digit[i] += ('A' - 1);			
			}
		}
		return new String(digit);
	}
	
	/** 
	 * this method returns the decrypted String from the String received as parameter
	 * according to the current key
	 */  
	public String decode(String coded) {
		// ignore if null
		if(coded == null)
			return "";
		// ignore if key length is 0
		if(key.length() == 0)
			return coded.toLowerCase();
		// by convention in the cryptology world all original messages are in lowercode 
		// and coded messages in uppercase
		// so let us put the original message in upper cases
		// convert the original message into an array of char
		char[] digit = coded.toUpperCase().toCharArray();
		// build a string with the repeated key at least the size of our message
		String longKey = key;
		while(longKey.length() < coded.length())
			longKey += key;
		
		// pass through all input digits to convert them
		for(int i = 0; i < digit.length; i++) {
			// if they are not between 'A' and 'Z' just ignore them (message has been translated to uppercase)
			if(digit[i] < 'A' || digit[i] > 'Z') 
				continue;
			
			// find out by how much we shift (like in a Ceasar code)
			char offset = longKey.charAt(i);
			// subtract 'A' for it for the number of shift
			int nbShift = offset - 'A';
			// convert the digit to lowerrcase (as we mentionned this is a standard cryptographic convention)
			digit[i] = Character.toLowerCase(digit[i]);
			// applied the shift to it
			digit[i] -= nbShift;
			// wrap around if before 'A'
			if(digit[i] < 'a') {
				digit[i] += 'z';
				digit[i] -= ('a' - 1);			
			}

		}
		return new String(digit);
	}
	
	/**
	 * To test our class
	 */
	public static void main(String[] args) {
		
		//------------------------------------------------------------------
		// Automatic tests
		//------------------------------------------------------------------
		
		// test with the whole alphabet
		Vigenere vigenere = new Vigenere("DreamInCode");
		// code the whole alpahabet
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		// code it
		String coded = vigenere.encode(alphabet);
		System.out.println("Coded alphabet is: " + coded);
		// decode it back
		String clear = vigenere.decode(coded);
		System.out.print("  Alphabet back ?: " + clear);
		// print if we succeed
		if(alphabet.equals(clear))
			System.out.println("   Seems to work :-)");
		else
			System.out.println("   Oups !!! Bug ...");
		System.out.println();
		
		// now test that frequency will be defeated
		// (we should find the key "Another Key" under the aaaaaaaaaa
		//  with the Ceasar encoding all e would have the same encoding)
		String freq = "eeeeeeeeeeeeeeeeaaaaaaaaaaaaaaaazzzzzzzzzzzzzzz";
		// use another key
		vigenere.setKey("AnotherKey");
		// print out initial String
		System.out.println("Frequency test");
		System.out.println("Frequency String: " + freq);
		// encode it
		coded = vigenere.encode(freq);
		// print the coded string and its translation back
		System.out.println(" as coded String: " + coded);
		System.out.println("     end back ? : " + vigenere.decode(coded));
		System.out.println();
		
		//-------------------------------------------------------------------
		// End of automatic tests
		// you can remove all the automatic tests code in production
		//-------------------------------------------------------------------
		
		// now test from user input 
		// build a Scanner to read from the console
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the key: ");
		// read the key and create a Vigenere object with it
		String key = scan.nextLine();
		Vigenere userVigenere = new Vigenere(key);
		// input message from user
		System.out.print("Enter message: ");
		String message = scan.nextLine();
		System.out.println("          Original: " + message);
		// code it and decode it back
		coded = userVigenere.encode(message);
		System.out.println("Encoded message is: " + coded);
		System.out.println("translated back ? : " + userVigenere.decode(coded));		
	}
}
