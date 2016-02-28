//Chapter4 - Project 4.1
public class Triangle 
{
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private double x3;
	private double y3;
	private double len;
	private double lenA;
	private double lenB;
	private double lenC;
	private double rad;
	private double radA;
	private double radB;
	private double radC;
	private double perimeter;
	private double area;
	
	public Triangle()
	{
	x1 = 0;
	y1 = 0;
	x2 = 0;
	y2 = 0;
	x3 = 0;
	y3 = 0;
	len = 0;
	lenA = 0;
	lenB = 0;
	lenC = 0;
	rad = 0;
	radA = 0;
	radB = 0;
	radC = 0;
	perimeter = 0;
	area = 0;
	}
	
	public void getFirstCorner (double X1, double Y1)
	{
	this.x1 = this.x1 + X1;
	this.y1 = this.y1 + Y1;
	}
	
	public void getSecondCorner (double X2, double Y2)
	{
	this.x2 = this.x2 + X2;
	this.y2 = this.y2 + Y2;
	}
	
	public void getThirdCorner (double X3, double Y3)
	{
	this.x3 = this.x3 + X3;
	this.y3 = this.y3 + Y3;
	}
	
	public double getFirstLength()
	{
	double firstLen = (double)(Math.sqrt((Math.pow((x2-x1),2))+((Math.pow((y2-y1),2)))));
	this.lenA = this.lenA + firstLen;
	return this.lenA;
	}
	
	public double getSecondLength()
	{
	double secondLen = (double)(Math.sqrt((Math.pow((x3-x1),2))+((Math.pow((y3-y1),2)))));
	this.lenB = this.lenB + secondLen;
	return this.lenB;
	}
	
	public double getThirdLength()
	{
	double thirdLen = (double)(Math.sqrt((Math.pow((x3-x2),2))+((Math.pow((y3-y2),2)))));
	this.lenC = this.lenC + thirdLen;
	return this.lenC;
	}	
	
	public double getLargestLength()
	{
	this.len = this.len + Math.max(lenA, (Math.max(lenB, lenC)));
	return this.len;
	}
	
	public double getFirstLargestAngle()
	{
	if ((lenA>lenB)&&(lenA>lenC))
		{
		double largestA = (double)(((Math.pow(lenB,2))+(Math.pow(lenC,2))-(Math.pow(lenA,2)))/(2*lenB*lenC));
		double largestA1 = (double)(Math.acos(largestA)*180/Math.PI);
		this.rad = this.rad + largestA1;
		this.radA = this.radA + this.rad;
		return this.radA;
		}
	else if ((lenB>lenA)&&(lenB>lenC))
		{
		double largestB = (double)(((Math.pow(lenA,2))+(Math.pow(lenC,2))-(Math.pow(lenB,2)))/(2*lenA*lenC));
		double largestB1 = (double)(Math.acos(largestB)*180/Math.PI);
		this.rad = this.rad + largestB1;
		this.radA = this.radA + this.rad;
		return this.radA;
		}
	else 
		{
		double largestC = (double)(((Math.pow(lenA,2))+(Math.pow(lenB,2))-(Math.pow(lenC,2)))/(2*lenA*lenB));
		double largestC1 = (double)(Math.acos(largestC)*180/Math.PI);
		this.rad = this.rad + largestC1;
		this.radA = this.radA + this.rad;
		return this.radA;
		}
	}
	
	public double getSecondLargestAngle()
	{
	if ((lenA>lenB && lenA<lenC)|| (lenA>lenC && lenA<lenB))
		{
		double secLargestA = (double)((lenA*(Math.sin(radA*Math.PI/180)))/len);
		double secLargestA1 = (double)(Math.asin(secLargestA)*180/Math.PI);
		this.radB = this.radB + secLargestA1;
		return this.radB;
		}
	else if ((lenB>lenA && lenB<lenC) || (lenB>lenC && lenB<lenA))
		{
		double secLargestB = (double)((lenB*(Math.sin(radA*Math.PI/180)))/len);
		double secLargestB1 = (double)(Math.asin(secLargestB)*180/Math.PI);
		this.radB = this.radB + secLargestB1;
		return this.radB;
		}
	else 
		{
		double secLargestC = (double)((lenC*(Math.sin(radA*Math.PI/180)))/len);
		double secLargestC1 = (double)(Math.asin(secLargestC)*180/Math.PI);
		this.radB = this.radB + secLargestC1;
		return this.radB;
		}
	}
	
	public double getThirdLargestAngle()
	{
	double thirdLargestC = (double)(180);
	this.radC = this.radC + thirdLargestC - this.radA - this.radB;
	return this.radC;
	}
	
	public double getPerimeter()
	{
	this.perimeter = this.lenA + this.lenB + this.lenC;
	return this.perimeter;
	}
	
	public double getArea()
	{
	double kawasan = this.perimeter/2;
	double kawasan2 = (double)(kawasan*(kawasan-lenA)*(kawasan-lenB)*(kawasan-lenC));
	double kawasan3 = (double)(Math.sqrt(kawasan2));
	this.area = this.area + kawasan3;
	return this.area;
	}
}