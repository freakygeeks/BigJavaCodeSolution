//Chapter 26 - Example 26.2

import java.util.ArrayList;

public class ItemListParserDemo
{
	public static void main (String[] args) throws Exception
	{
		ItemListParser parser = new ItemListParser();
		ArrayList<LineItem> items = parser.parse("items.xml");
		
		for (LineItem anItem : items)
		{
			System.out.println(anItem.format());
		}
	}
}