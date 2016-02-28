//Chapter3 - Exercise P3.14
import java.util.GregorianCalendar;
import java.util.Calendar;

public class VotingMachineTester
{
	public static void main (String[] args)
	{
	GregorianCalendar voteDay = new GregorianCalendar();
	voteDay.set(Calendar.YEAR, voteDay.get(Calendar.YEAR));
	voteDay.set(Calendar.MONTH, Calendar.APRIL);
	voteDay.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2);
	voteDay.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	voteDay.set(Calendar.HOUR_OF_DAY, 15);
	voteDay.set(Calendar.MINUTE, 0);
	voteDay.set(Calendar.SECOND, 0);
	voteDay.getTime();	
	
	VotingMachine vote = new VotingMachine();
	vote.addDemocrat();
	vote.addDemocrat();
	vote.addDemocrat();
	vote.addRepublican();
	
	String Democrat = vote.getDemocrat();
	String Republican = vote.getRepublican(voteDay);
	
	System.out.println (Democrat);
	System.out.println (Republican);
	
	vote.clear();
	}
}