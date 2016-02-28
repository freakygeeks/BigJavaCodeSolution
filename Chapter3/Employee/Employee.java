//Chapter3 - Exercise P3.4 & P3.5
public class Employee
{
	private String name;
	private double salary;
	
	public Employee()
	{
	name = " ";
	salary = 0;
	}
	
	public void empName (String nama)
	{
	String newName = this.name + nama;
	this.name = newName;
	}
	
	public void empSalary (double amount)
	{
	double newSalary = this.salary + amount;
	this.salary = newSalary;
	}
	
	public String getName ()
	{
	return this.name;
	}
	
	public double getSalary ()
	{
	return this.salary;
	}
}