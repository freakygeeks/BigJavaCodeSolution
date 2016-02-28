//Chapter3 - Exercise P3.14
import java.util.GregorianCalendar;
import java.util.Calendar;

public class VotingMachine
{
	private int Democrat;
	private int Republican;
	
	public VotingMachine()
	{
	Democrat = 0;
	Republican = 0;
	}
	
	public void addDemocrat()
	{
	int newDemo = this.Democrat + 1;
	this.Democrat = newDemo;
	}
	
	public void addRepublican()
	{
	int newRep = this.Republican + 1;
	this.Republican = newRep;
	}
	
	public void clear()
	{
	Democrat = 0;
	Republican = 0;
	}
	
	public String getDemocrat()
	{
	return "The total vote for Democrat are " + this.Democrat;
	}
	
	public String getRepublican(GregorianCalendar voteDay)
	{
	GregorianCalendar today = new GregorianCalendar();
	if(today.after(voteDay))
	{
	return "The total vote for Republican are " + this.Republican + ". Go Go Republican!";
	}
	else 
	{
	return "The total vote for Republican are " + this.Republican;
	}
	}
}