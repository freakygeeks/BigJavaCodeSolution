//Chapter4 - Exercise 4.12
public class DigitExtractor
{
	private int num;
	
	public DigitExtractor()
	{
	num = 0;
	}
	
	public void insertDigit(int number)
	{
	this.num = this.num + number;
	}
	
	public int nextDigit()
	{
	int numb = 0;
	if(num>0)
		{
		numb = num % 10; //12345 mod 10 = 5 (remainder for first number)
		num = num/10; //12345 div 10 = 1234 (value for next num)
		}
	return numb;
	}
}