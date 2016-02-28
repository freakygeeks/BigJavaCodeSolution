 
public class VigenereCipher
{
    public static String encrypt(String text, final String key)
    {
        String res = ""; //string result initiate as null
        text = text.toLowerCase(); //get text convert to lowercase
        for (int i = 0, j = 0; i < text.length(); i++) //loop on text
        {
            char c = text.charAt(i); //char in text
            if (c < 'a' || c > 'z') //if a and z, continue loop
                continue;

			res = res + (char) ((c + key.charAt(j) - 2 * 'a') % 26 + 'a'); //string result plus char find
            //j = ++j % key.length();
			j = (j++ +1) % key.length();
			System.out.println (c + " = " + res);
        }
        return res;
    }
 
    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toLowerCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'a' || c > 'z')
                continue;
            res = res + (char) ((c - key.charAt(j) + 26) % 26 + 'a');
            //j = ++j % key.length();
			j = (j++ +1) % key.length();
        }
        return res;
    }
 
    public static void main(String[] args)
    {
        String key = "TIGER";
		key = key.toLowerCase();
        String message = "JAVA STYLE GUIDELINES"; //cibejmgrixnqjicbvkw
		message = message.toLowerCase();
		
        String encryptedMsg = encrypt(message, key);
        System.out.println("String: " + message);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg, key));
    }
}