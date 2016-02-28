//Chapter 9 - Exercise 9.5

import javax.swing.JOptionPane;

public class GeometryTester
{
	public static void main (String[] args)
	{
		String input = JOptionPane.showInputDialog("Please enter the radius : ");
		double r = Double.parseDouble(input);
		
		input = JOptionPane.showInputDialog("Please enter the height : ");
		double h = Double.parseDouble(input);
		
		System.out.println("The volume of the sphere is: " + Geometry.sphereVolume(r));
		System.out.println("The surface area of the sphere is: " + Geometry.sphereSurface(r));
		System.out.println("The volume of the cylinder is: " + Geometry.cylinderVolume(r, h));
		System.out.println("The surface area of the cylinder is: " + Geometry.cylinderSurface(r, h));
		System.out.println("The volume of the cone is: " + Geometry.coneVolume(r, h));
		System.out.println("The surface area of the cone is: " + Geometry.coneSurface(r, h));

		System.exit(0);
	}
}