//Chapter11 - Exercise P11.4

public class PersonTester
{
	public static void main (String[] args)
	{
	DataSet personData = new DataSet();
	
	personData.add(new Person(1.99, "Ali"));
	personData.add(new Person(1.77, "Wak"));
	personData.add(new Person(2.30, "Abu"));
	personData.add(new Person(2.05, "Joe"));
	
	Measureble max = personData.getMaximum();
	Measureble min = personData.getMinimum();
	
	Person maxPerson = (Person) max;
	String nameMax = maxPerson.getName();
	
	Person minPerson = (Person) min;
	String nameMin = minPerson.getName();
	
	System.out.println ("Max height is : " + max.getMax());
	System.out.println ("Max person name is : " + nameMax);
	System.out.println ("\nAverage height is : " + personData.getAverage());	
	System.out.println ("\nMin height is : " + min.getMin());
	System.out.println ("Min person name is : " + nameMin);
	}
}