//Chapter3 - Exercise P3.11
public class SodaCanTester
{
	public static void main (String[] args)
	{
	SodaCan volume = new SodaCan();
	volume.addVolume(4, 12);
	
	double newVolume1 = volume.getArea();
	double newVolume2 = volume.getVolume();
	
	System.out.println ("The soda can surface area is : " + newVolume1 + " " + "and the volume is : " + newVolume2);
	}
}