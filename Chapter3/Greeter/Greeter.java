//Chapter3 - Project 3.2
public class Greeter
{
	private String one;
	private String two;
	
	public Greeter()
	{
	one = " ";
	two = " ";
	}
	
	public void sayHello1 (String inputOne)
	{
	this.one = this.one + inputOne;
	}
	
	public void sayHello2 (String inputTwo)
	{
	this.two = this.two + inputTwo;
	}
	
	public void sayGoodbye ()
	{
	this.one = this.one;
	this.two = this.two;
	}
	
	public void refuseHelp()
	{
	this.one = this.one;
	this.two = this.two;
	}
	
	public String getHello1()
	{
	return "Hello," + this.one;
	}
	
	public String getHello2()
	{
	return "Hello," + this.two;
	}
	
	public String getGoodbye1()
	{
	return "Goodbye" + this.one;
	}
	
	public String getGoodbye2()
	{
	return "Goodbye," + this.two;
	}
	
	public String getRefuse()
	{
	return "I am sorry, " + this.two + ". I am afraid I can't do that";
	}
}