//Chapter3 - Exercise P3.5
public class EmployeeRaise
{
	private String name;
	private double salary;
	
	public EmployeeRaise()
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
	
	public void empRaise (double rate)
	{
	double newRaise = ((this.salary*rate)/100) + this.salary;
	this.salary = newRaise;
	}
	
	public void addRaise()
	{
	this.empRaise(10);
	}
	
	public String getName()
	{
	return this.name;
	}
	
	public double getSalary()
	{
	return this.salary;
	}
}