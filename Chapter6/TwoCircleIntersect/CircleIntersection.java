/*
-----------------------------------------------------------------------------------------------------------------------------------
This program is use to calculate the intersection between two circle given both of the circle center point and radius in Java programming language. Example such as center for point A is (2,3) with radius 3. Meanwhile center point B is (1,-1) with radius 4. The answer for intersection would be at coordinate (- 0.96 , 2.49) and (4.37 , 1.16) respectively.
-----------------------------------------------------------------------------------------------------------------------------------
Copyright (C) 2014 by NieSe.

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

public class CircleIntersection
{
	private double a1;
	private double b1;
	private double r1;
	private double a2;
	private double b2;
	private double r2;
	
	public CircleIntersection(double xa1, double yb1, double rad1, double xa2, double yb2, double rad2)
	{
	a1 = xa1;
	b1 = yb1;
	r1 = rad1;
	a2 = xa2;
	b2 = yb2;
	r2 = rad2;
	}
	
	public boolean getEquation()
	{
	//first equation
	double Xa1 = (-2)*(a1);
	double Yb1 = (-2)*(b1);
	double c = Math.pow(a1,2)+Math.pow(b1,2)-Math.pow(r1,2);
	
	//second equation
	double Xa2 = (-2)*(a2);
	double Yb2 = (-2)*(b2);
	double d = Math.pow(a2,2)+Math.pow(b2,2)-Math.pow(r2,2);
	
	//value for x
	double e = c-d;
	double f = (2*(b1-b2)/2*(a1-a2));
	double g = e/2*(a1-a2);
	
	//value for quadratic
	double h = Math.pow(f,2)+1;
	double i = ((-2)*f*g)-((-2)*f*a1)-(2*b1);
	double j = Math.pow(g,2)-(2*g*a1)+c;
	
	//solution for both of y point
	double solutionY1 = (double)((-i+(Math.sqrt((Math.pow(i,2))-(4*h*j))))/(2*h)); 
	double solutionY2 = (double)((-i-(Math.sqrt((Math.pow(i,2))-(4*h*j))))/(2*h));
	
	//solution for both of x point
	double solutionX1 = (-solutionY1)*(f)+g;
	double solutionX2 = (-solutionY2)*(f)+g;
	
	System.out.println ("First equation  = x^2 + " + Xa1 + "x + y^2 + " + Yb1 + "y + " + (c));
	System.out.println ("Second equation = x^2 + " + Xa2 + "x + y^2 + " + Yb2 + "y + " + (d));
	System.out.println ("Value e = " + e);
	System.out.println ("Value f = " + f);
	System.out.println ("Value g = " + g);
	System.out.println ("Value h = " + h);
	System.out.println ("Value i = " + i);
	System.out.println ("Value j = " + j);
	
	System.out.println ("Quadratic equation = " + h + "x^2 + " + i + "x + " + j);
	
	System.out.println ("Intersection at first point of Y = " + solutionY1);
	System.out.println ("Intersection at second point of Y = " + solutionY2);
	
	System.out.println ("Intersection at first point of X = " + solutionX1);
	System.out.println ("Intersection at second point of X = " + solutionX2);
	
	System.out.println ("Intersection is at : (" +  solutionX1 + "," + solutionY1 + ") and (" + solutionX2 + "," + solutionY2 + ")");  
	
	double discrimi = (double)((i*i)-4*h*j);
		if (discrimi < 0)
		{
		return false;
		}
	else 
		return true;
	}
}