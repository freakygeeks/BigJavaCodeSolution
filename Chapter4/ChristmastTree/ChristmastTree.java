//Chapter4 - Exercise 4.16
public class ChristmastTree
{
	private String tree;
	
	public ChristmastTree()
	{
	tree = " ";
	}
	
	public String getTree()
	{
	this.tree = this.tree + "\n    /\\   \n   /  \\  \n  /    \\ \n /      \\ \n -------- \n   \"  \"  \n   \"  \"  \n   \"  \"  \n";
	return tree;
	}
}