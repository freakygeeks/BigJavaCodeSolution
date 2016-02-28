
import java.io.*;
import java.util.regex.*;

public class ShowLinks 
{
    public static void main(String[] arguments) 
	{
        if (arguments.length < 1) 
		{
            System.out.println("Usage: java ShowLinks [page]");
            System.exit(0);
        }
		
        String page = loadPage(arguments[0]);
        Pattern pattern = Pattern.compile("<a.+href=\"(.+?)\"");
        Matcher matcher = pattern.matcher(page);
        while (matcher.find()) 
		{
            System.out.println( matcher.group(1));
        }
    }

    private static String loadPage(String name) 
	{
        StringBuffer output = new StringBuffer();
		
        try 
		{
            FileReader file = new FileReader(name);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            while (!eof) 
			{
                String line = buff.readLine();
                if (line == null)
                    eof = true;
                else
                    output.append(line + "\n");
            }
            buff.close();
        } 
		
		catch (IOException e) 
		{
            System.out.println("Error -- " + e.toString());
        }
		
        return output.toString();
    }
}