//Chapter 13 - Exercise 13.6

public class WorkerPolymorphism
{
	public double salary (HourlyWorker h, int hour)
	{
		return h.computePay(hour);
	}

	public double salary (SalaryWorker s, int hour)
	{
		return s.computePay(hour);
	}
}