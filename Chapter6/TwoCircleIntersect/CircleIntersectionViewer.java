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

import java.util.Scanner;

public class CircleIntersectionViewer
{
	public static void main (String[] args)
	{
	Scanner in = new Scanner(System.in);
	
	System.out.print ("Please enter first circle coordinate X : ");
	double x1 = in.nextDouble();
	
	System.out.print ("Please enter first circle coordinate Y : ");
	double y1 = in.nextDouble();
	
	System.out.print ("Please enter first circle radius : ");
	double r1 = in.nextDouble();
	
	System.out.print ("Please enter second circle coordinate X : ");
	double x2 = in.nextDouble();
	
	System.out.print ("Please enter second circle coordinate Y : ");
	double y2 = in.nextDouble();
	
	System.out.print ("Please enter second circle radius : ");
	double r2 = in.nextDouble();
	
	CircleIntersection calc = new CircleIntersection(x1, y1, r1, x2, y2, r2);
	System.out.println("Discriminant value is : " + calc.getEquation());
	}
}