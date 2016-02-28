//Chapter3 - Exercise P3.12
public class RoachPopulation
{
	private double population;
	
	public RoachPopulation()
	{
	population = 0;
	}
	
	public void waitForDoubling (double doubling)
	{
	double newDoubling = this.population + (doubling*doubling);
	this.population = newDoubling;
	}
	
	public void spray (double reduces)
	{
	double newReduces = this.population*(reduces/100);
	this.population = newReduces;
	}
	
	public double getRoaches()
	{
	return this.population;
	}
}