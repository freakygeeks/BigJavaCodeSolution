//  class Employee -- a class for Employees

public class Employee implements Sortable {
    private int SSNum;          //  the social security number
    private String firstname;
    private String lastname;
    private int salary;

    public Employee() {    }

    public Employee(int SSN, String first, String last, int sal) {
        SSNum = SSN;
        firstname = first;
        lastname = last;
        salary = sal;
    }

//  compare function required by Sortable interface
//  orders Employees by social security number

    public int compare(Sortable another) {
        return ((Employee)this).SSNum - ((Employee) another).SSNum;
    }

//  allows us to print an Employee

    public String toString() {
        String emp;
        emp = Integer.toString(SSNum) + "     " + lastname + "  "
                   + firstname + "     " + Integer.toString(salary);
        return emp;
    }
}	// end class Employee

