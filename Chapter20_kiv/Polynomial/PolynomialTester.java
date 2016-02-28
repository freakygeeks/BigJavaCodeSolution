//Chapter 20 - Project 20.1

public class PolynomialTester
{
	public static void main (String[] args)
	{
		Polynomial p = new Polynomial();
		p.addTerm(-10, 0);
		p.addTerm(-1, 1);
		p.addTerm(9, 7);
		p.addTerm(5, 10);
		
		Polynomial q = p.multiply(p);
		
		q.print();
	}
}