//Chapter3 - Exercise P3.12
public class RoachPopulationTester
{
	public static void main (String[] args)
	{
	RoachPopulation roach = new RoachPopulation();
	roach.waitForDoubling(15);
	roach.spray(3);
	
	double newRoach = roach.getRoaches();
	
	System.out.println ("The number of roaches is : " + newRoach);
	}
}