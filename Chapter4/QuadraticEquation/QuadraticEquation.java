//Chapter4 - Exercise 4.13

public class QuadraticEquation
{
	private double firstNum;
	private double secondNum;
	private double thirdNum;
	
	public QuadraticEquation()
	{
	firstNum = 0;
	secondNum = 0;
	thirdNum = 0;
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
}