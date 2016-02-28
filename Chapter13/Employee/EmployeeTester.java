//Chapter 13 - Exercise 13.5

public class EmployeeTester
{
	public static void main (String[] args)
	{
		Employee e = new Employee("Edgar", 65000);
		Manager m = new Manager("Mary", 85000, "Engineering");
		Executive v = new Executive("Veronica", 105000, "Engineering");
		
		System.out.println(e);
		System.out.println(m);
		System.out.println(v);
	}
}