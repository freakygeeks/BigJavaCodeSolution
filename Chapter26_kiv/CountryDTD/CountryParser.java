//Chapter 26 - Exercise 26.13

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

public class CountryParser
{
	private DocumentBuilder builder;
	
	public CountryParser() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setIgnoringElementContentWhitespace(true);
		builder = factory.newDocumentBuilder();
	}
	
	//parses an XML file containing a country
	public ArrayList parse (String fileName) throws SAXException, IOException
	{
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		//get the <country> element
		return getCountries(doc.getDocumentElement());
	}
	
	//get the country object
	public ArrayList getCountries(Element e)
	{
		ArrayList countryList = new ArrayList();
		NodeList children = e.getChildNodes();
		
		for (int i = 0; i < children.getLength(); i++)
		{
			addCountry(countryList, (Element)children.item(1));
		}
		return countryList;
	}
	
	//add country to the country list
	private void addCountry (ArrayList countryList, Element e)
	{
		NodeList children = e.getChildNodes();
		String name;
		int population = 0;
		double area = 0.0;
		
		Element childElement = (Element)children.item(0);
		Text textNode = (Text)childElement.getFirstChild();
		name = textNode.getData();
		
		childElement = (Element)children.item(1);
		textNode = (Text)childElement.getFirstChild();
		population = Integer.parseInt(textNode.getData());
		
		childElement = (Element)children.item(2);
		textNode = (Text)childElement.getFirstChild();
		area = Double.parseDouble(textNode.getData());
		
		countryList.add(new Country(name, population, area));
	}
}
















