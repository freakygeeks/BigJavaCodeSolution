//Chapter 19 - Exercise 19.5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class LookupTable
{
	private Item[] items;
	private int itemCount;
	
	public LookupTable(int n)
	{
		items = new Item[n];
		itemCount = 0;
	}
	
	//read a file
	public void read (BufferedReader in) throws IOException
	{
		boolean more = true;
		while (more && itemCount < items.length)
		{
			String k = in.readLine();
			String v = null;
			
			if (k != null)
			{
				v = in.readLine();
			}
			
			if (v != null)
			{
				items[itemCount] = new Item(k, v);
				itemCount++;
			}
			
			else
			{
				more = false;
			}
		}
		
		MergeSorter m = new MergeSorter(items);
		m.sort();
	}
	
	//reverse lookup by reading phone numbers
	public void reverse (LookupTable b)
	{
		itemCount = Math.min(b.itemCount, items.length);
		
		for (int i = 0; i < itemCount; i++)
		{
			items[i] = new Item(b.items[i].getValue(), b.items[i].getKey());
		}
		
		MergeSorter m = new MergeSorter(items);
		m.sort();
	}
	
	//look up an entries in the list
	public String lookup (String k)
	{
		BinarySearcher b = new BinarySearcher(items);
		
		int pos = b.binarySearch(0, itemCount-1, k);
		
		if(pos < 0)
		{
			return "Not found";
		}
		
		else
		{
			return items[pos].getValue();
		}
	}
}























