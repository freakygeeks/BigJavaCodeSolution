//Chapter11 - Exercise P11.3

public class PersonTester
{
	public static void main (String[] args)
	{
	DataSet personData = new DataSet();
	
	personData.add(new Person(1.99, "Ali"));
	personData.add(new Person(2.05, "Joe"));
	personData.add(new Person(1.77, "Wak"));
	personData.add(new Person(2.30, "Abu"));
	
	Measure max = personData.getMax();
	
	Person maxPerson = (Person) max;
	String name = maxPerson.getName();
	
	System.out.println ("Max height is : " + max.getMax());
	System.out.println ("Person name is : " + name);
	System.out.println ("Average height is : " + personData.getAverage());	
	}
}