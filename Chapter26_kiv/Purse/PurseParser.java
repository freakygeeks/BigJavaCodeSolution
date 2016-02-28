//Chapter 26 - Exercise 26.1

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
		builder = factory.newDocumentBuilder();
	}
	
	//parses an XML file containing a purse
	public Purse parse (String fileName) throws SAXException, IOException
	{
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		//get the <purse> root elemet
		Element root = doc.getDocumentElement();
		return getPurse(root);
	}
	
	//obtain an item from a DOM element
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
	
	//obtain an array list of coins from a DOM element
	private static ArrayList getCoins (Element e)
	{
		ArrayList coins = new ArrayList();
		
		//get the <item> children
		NodeList children = e.getChildNodes();
		
		for (int i = 0; i < children.getLength(); i++)
		{
			Node childNode = children.item(i);
			
			if (childNode instanceof Element)
			{
				Element childElement = (Element)childNode;
				
				if (childElement.getTagName().equals("coin"))
				{
					Coin c = getCoin(childElement);
					coins.add(c);
				}
			}
		}
		
		return coins;
	}
	
	//obtain an item from a DOM element
	private static Coin getCoin (Element e)
	{
		NodeList children = e.getChildNodes();
		double value = 0.0;
		String name = "";
		
		for (int j = 0; j < children.getLength(); j++)
		{
			Node childNode = children.item(j);
			
			if (childNode instanceof Element)
			{
				Element childElement = (Element)childNode;
				String tagName = childElement.getTagName();
				
				if (tagName.equals("value"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					String data = textNode.getData();
					value = Double.parseDouble(data);
				}
				
				else if (tagName.equals("name"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					name = textNode.getData();
				}
			}
		}
		
		return new Coin(value, name);
	}
}























