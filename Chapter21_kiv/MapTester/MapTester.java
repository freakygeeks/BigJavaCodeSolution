//Chapter 21 - Example 21.2

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTester
{
	public static void main (String[] args)
	{
		Map<String, Color> favoriteColor = new HashMap<String, Color>();
		favoriteColor.put("Juliet", Color.PINK);
		favoriteColor.put("Romeo", Color.GREEN);
		favoriteColor.put("Adam", Color.BLUE);
		favoriteColor.put("Eve", Color.PINK);
		
		Set<String> keySet = favoriteColor.keySet();
		
		for (String key : keySet)
		{
			Color value = favoriteColor.get(key);
			System.out.println(key + " -> " + value);	
		}
	}
}