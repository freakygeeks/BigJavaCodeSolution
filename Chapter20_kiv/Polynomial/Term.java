//Chapter 20 - Project 20.1

public class Term
{
	private double coeff;
	private int degree;
	
	public Term(double c, int d)
	{
		coeff = c;
		degree = d;
	}
	
	//multiplies a term
	public Term multiply (Term other)
	{
		return new Term(coeff * other.coeff, degree + other.degree);
	}
	
	//add coefficient
	public void add (double c)
	{
		coeff = coeff + c;
	}
	
	//get coefficent
	public double getCoeff()
	{
		return coeff;
	}
	
	//get degree
	public int getDegree()
	{
		return degree;
	}
}

















