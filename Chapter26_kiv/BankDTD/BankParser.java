//Chapter 26 - Exercise 26.5

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class BankParser
{
	private DocumentBuilder builder;
	
	public BankParser() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setIgnoringElementContentWhitespace(true);
		builder = factory.newDocumentBuilder();
	}
	
	//parser an XML file containing a bank
	public Bank parse (String fileName) throws SAXException, IOException
	{
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		//get the <bank> root element
		
		Element root = doc.getDocumentElement();
		return getBank(root);
	}
	
	//obtain an item from a DOM element
	private static Bank getBank(Element e)
	{
		ArrayList accounts = getAccounts(e);
		Bank b = new Bank();
		
		for (int i = 0; i < accounts.size(); i++)
		{
			b.createAccount((BankAccount)accounts.get(i));
		}
		
		return b;
	}
	
	//obtains an array list of accounts from a DOM element
	private static ArrayList getAccounts(Element e)
	{
		ArrayList accounts = new ArrayList();
		
		//get the <account> children
		
		NodeList children = e.getChildNodes();
		
		for (int i = 0; i < children.getLength(); i++)
		{
			Element childElement = (Element)children.item(i);
			BankAccount c = getAccount(childElement);
			accounts.add(c);
		}
		
		return accounts;
	}
	
	//obtains an item from a DOM element
	private static BankAccount getAccount(Element e)
	{
		NodeList children = e.getChildNodes();
		int number = 0;
		double balance = 0.0;
		
		Element childElement = (Element)children.item(0);
		Text textNode = (Text)childElement.getFirstChild();
		String data = textNode.getData();
		number = Integer.parseInt(data);
		
		childElement = (Element)children.item(1);
		Text balanceNode = (Text)childElement.getFirstChild();
		String data2 = balanceNode.getData();
		balance = Double.parseDouble(data2);
		
		return new BankAccount(number, balance);		
	}
}




















