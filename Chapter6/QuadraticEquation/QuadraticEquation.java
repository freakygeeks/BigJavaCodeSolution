//Chapter6 - Exercise P6.1
public class QuadraticEquation
{
	private double firstNum;
	private double secondNum;
	private double thirdNum;
	private double solution1;
	private double solution2;	
	private double discriminant1;
	
	public QuadraticEquation()
	{
	firstNum = 0;
	secondNum = 0;
	thirdNum = 0;
	solution1 = 0;
	solution2 = 0;
	discriminant1 = 0;
	}
	
	public void getValue (double first, double second, double third)
	{
	this.firstNum = this.firstNum + first;
	this.secondNum = this.secondNum + second;
	this.thirdNum = this.thirdNum + third;
	}
	
	public double getSolutionOne()
	{
	double solution1 = (double)((-secondNum+(Math.sqrt((Math.pow(secondNum,2))-(4*firstNum*thirdNum))))/(2*firstNum));
	return solution1;
	}
	
	public double getSolutionTwo()
	{
	double solution2 = (double)((-secondNum-(Math.sqrt((Math.pow(secondNum,2))-(4*firstNum*thirdNum))))/(2*firstNum));
	return solution2;
	}

	public double getDiscriminant()
	{
	double discrimi = (double)((secondNum*secondNum)-4*firstNum*thirdNum);
	this.discriminant1 = this.discriminant1 + discrimi;
	return discriminant1;		
	}
	
	public boolean hasSolution()
	{
	if (discriminant1 < 0)
		{
		return false;
		}
	else 
		return true;
	}
}