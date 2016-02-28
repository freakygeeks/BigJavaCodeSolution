//Chapter 26 - Exercise 26.3

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

public class PurseParser
{
	private DocumentBuilder builder;
	
	public PurseParser() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setIgnoringElementContentWhitespace(true);
		builder = factory.newDocumentBuilder();
	}
	
	//parses an XML file containing a purse
	public Purse parse (String fileName) throws SAXException, IOException
	{
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		//get the <purse> root element
		
		Element root = doc.getDocumentElement();
		return getPurse(root);
	}
	
	//obtains an item from a DOM element
	private static Purse getPurse(Element e)
	{
		ArrayList coins = getCoins(e);
		Purse p = new Purse();
		
		for (int i = 0; i < coins.size(); i++)
		{
			p.add((Coin)coins.get(i));
		}
		return p;
	}
	
	//obtains an array list of coins from a DOM element
	private static ArrayList getCoins(Element e)
	{
		ArrayList coins = new ArrayList();
		
		//get the <coin> children
		
		NodeList children = e.getChildNodes();
		
		for (int i = 0; i < children.getLength(); i++)
		{
			Element childElement = (Element)children.item(i);
			Coin c = getCoin(childElement);
			coins.add(c);
		}
		
		return coins;
	}
	
	//obtains an item from a DOM element
	private static Coin getCoin (Element e)
	{
		NodeList children = e.getChildNodes();
		double value = 0.0;
		String name = "";
		
		Element valueElement = (Element)children.item(0);
		Text textNode = (Text)valueElement.getFirstChild();
		String data = textNode.getData();
		value = Double.parseDouble(data);
		
		Element nameElement = (Element)children.item(1);
		Text nameNode = (Text)nameElement.getFirstChild();
		name = nameNode.getData();
		
		return new Coin(value, name);
	}
}



























