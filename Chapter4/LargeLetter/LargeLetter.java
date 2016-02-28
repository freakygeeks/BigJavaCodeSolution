//Chapter4 - Exercise 4.15
public class LargeLetter
{
	private String LetterH;
	private String LetterE;
	private String LetterL1;
	private String LetterL2;
	private String LetterO;
	
	public LargeLetter()
	{
	LetterH = " ";
	LetterE = " ";
	LetterL1 = " ";
	LetterL2 = " ";
	LetterO = " ";
	}
	
	public String getLetterH()
	{
	this.LetterH = this.LetterH + "*   *\n *   *\n *****\n *   *\n *   *\n";
	return LetterH;
	}
	
	public String getLetterE()
	{
	this.LetterE = this.LetterE + "***** \n *\n *****\n *\n *****";
	return LetterE;
	}
	
	public String getLetterL1()
	{
	this.LetterL1 = this.LetterL1 + "* \n * \n * \n * \n *****";
	return LetterL1;
	}
	
	public String getLetterL2()
	{
	this.LetterL2 = this.LetterL2 + "* \n * \n * \n * \n *****";
	return LetterL2;
	}
	
	public String getLetterO()
	{
	this.LetterO = this.LetterO + "***** \n *   * \n *   * \n *   * \n *****";
	return LetterO;
	}	
}