//Chapter 19 - Project 19.2

import java.applet.Applet;
import javax.swing.JOptionPane;

public class MergeSort
{
	private int[] a;
	private Applet applet;
	
	public MergeSort(int[] anArray, Applet anApplet)
	{
		a = anArray;
		applet = anApplet;
	}
	
	public void sort (int from, int to)
	{
		if (to-from <= 0)
		{
			return;
		}
		
		int mid = (from+to)/2;
		
		sort(from, mid);
		sort(mid+1, to);
		merge(from, mid, to);
		
		JOptionPane.showMessageDialog(null, "Next Step");
		applet.repaint();
	}
	
	private void merge (int from, int mid, int to)
	{
		int[] temp = new int[to-from+1];
		
		int iFirst = from;
		int iSecond = mid+1;
		int j = 0;
		
		while (iFirst <= mid && iSecond <= to)
		{
			if (a[iFirst] < a[iSecond])
			{
				temp[j] = a[iFirst];
				iFirst++;
			}
			
			else
			{
				temp[j] = a[iSecond];
				iSecond++;
			}
			j++;
		}
		
		while (iFirst <= mid)
		{
			temp[j] = a[iFirst];
			iFirst++;
			j++;
		}
		
		while (iSecond <= to)
		{
			temp[j] = a[iSecond];
			iSecond++;
			j++;
		}
		
		System.arraycopy(temp, 0, a, from, temp.length);
	}
}












