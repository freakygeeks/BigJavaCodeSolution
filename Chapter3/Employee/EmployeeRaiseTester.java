//Chapter3 - Exercise P3.5
public class EmployeeRaiseTester
{
	public static void main (String[] args)
	{
	EmployeeRaise raise = new EmployeeRaise();
	raise.empName("Harry");
	raise.empSalary(55000);
	raise.addRaise();
	
	String newName = raise.getName();
	double newSalary = raise.getSalary();
	
	System.out.println ("This employee name is : " + newName);
	System.out.println ("New salary after salary raise is : RM" + newSalary);
	}
}