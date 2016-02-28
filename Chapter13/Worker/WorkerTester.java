//Chapter 13 - Exercise 13.6

public class WorkerTester
{
	public static void main (String[] args)
	{
		WorkerPolymorphism w = new WorkerPolymorphism();
		HourlyWorker h = new HourlyWorker("Zizan", 1.5);
		SalaryWorker s = new SalaryWorker("Johan", 1.5);
		
		System.out.println("Hourly salary for " + h + w.salary(h,45) + " test " + h.computePay(45));
		System.out.println("Salary for " + s + w.salary(s,45) + " test " + s.computePay(45));
	}
}