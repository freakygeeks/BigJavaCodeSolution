//Chapter 20 - Project 20.1

import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial
{
	private LinkedList terms;
	
	public Polynomial()
	{
		terms = new LinkedList();
	}
	
	//add polynomial
	public Polynomial add(Polynomial p)
	{
		Polynomial r = new Polynomial();
		ListIterator iterator = terms.listIterator();
		
		while (iterator.hasNext())
		{
			r.add((Term)iterator.next());
		}
		
		ListIterator pIterator = p.terms.listIterator();
		
		while (pIterator.hasNext())
		{
			r.add((Term)pIterator.next());
		}
		
		return r;
	}
	
	//multiply a polynomial
	public Polynomial multiply (Polynomial p)
	{
		Polynomial r = new Polynomial();
		ListIterator iterator = terms.listIterator();
		
		while (iterator.hasNext())
		{
			ListIterator pIterator = p.terms.listIterator();
			Term t1 = (Term)pIterator.next();
			
			while (pIterator.hasNext())
			{
				Term t2 = (Term)pIterator.next();
				r.add(t1.multiply(t2));
			}
		}
		
		return r;
	}
	
	//add coefficient and degree as new Term
	public void addTerm (double c, int d)
	{
		add(new Term(c,d));
	}
	
	//add term
	public void add (Term t)
	{
		double c = t.getCoeff();
		int d = t.getDegree();
		
		ListIterator iterator = terms.listIterator();
		
		while(iterator.hasNext())
		{
			Term current = (Term)iterator.next();
			
			if (d == current.getDegree())
			{
				if (c == -current.getCoeff())
				{
					iterator.remove();
				}
				
				else
				{
					current.add(c);
				}
			}
			
			else if (d < current.getDegree())
			{
				iterator.previous();
				iterator.add(t);
				return;
			}
		}
		iterator.add(t);
	}
	
	//print the polynomial
	public void print()
	{
		ListIterator iterator = terms.listIterator();
		
		while (iterator.hasNext())
		{
			Term current = (Term)iterator.next();
			
			if (current.getCoeff() != 0)
			{
				if (current.getCoeff() > 0)
				{
					System.out.print(" + ");
				}
				System.out.print(current.getCoeff());
				
				if (current.getDegree() > 0)
				{
					System.out.print(" * x");
					if (current.getDegree() > 1)
					{
						System.out.print("^" + current.getDegree());
					}
				}
			}
		}
		
		System.out.println();
	}
}









