//Chapter8 - Exercise P8.10

import java.util.ArrayList;

public class IntNumber
{
	private ArrayList<Integer> numList;
	private Integer num;
	
	public IntNumber()
	{
	numList = new ArrayList<Integer>();
	num = 0;
	}
	
	public void addNum(Integer n)
	{
		numList.add(n);
	}
	
	public Integer toInteger()
	{
	int num1 = 0;
	int num2 = 0;
	
	for (int i = 0; i < numList.size(); i++)
		{
		if (i % 2 == 0)
			{
			num1 = num1 + numList.get(i);
			System.out.println("Num1 " + num1+ " ");
			}
		else
			{
			num2 = num2 + numList.get(i);
			System.out.println("Num2 " + num2+ " ");
			}
			num = num1 - num2;
		}
	System.out.println();
	return num;
	}
}
	