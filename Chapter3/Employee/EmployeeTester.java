//Chapter3 - Exercise P3.4 & P3.5
public class EmployeeTester
{
	public static void main(String[] args)
	{
	Employee emp = new Employee();
	emp.empName("Siti");
	emp.empSalary(1000);
	
	String newName = emp.getName();
	Double newSalary = emp.getSalary();
	
	System.out.println ("The employee name is : " + newName);
	System.out.println ("This employee salary is : RM" + newSalary);
	}
}