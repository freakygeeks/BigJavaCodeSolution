//Chapter 26 - Exercise 26.15

import java.io.File;
import java.io.IOException;
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

public class InvoiceParser
{
	private double totalAmount = 0.0;
	private DocumentBuilder builder;
	
	public InvoiceParser() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setIgnoringElementContentWhitespace(true);
		builder = factory.newDocumentBuilder();
	}
	
	//parses an XML file containing an invoice
	public void parse (String fileName) throws SAXException, IOException
	{
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		//get the <invoice> element
		printInvoice(doc.getDocumentElement());
	}
	
	//print an invoice
	public void printInvoice(Element e)
	{
		NodeList children = e.getChildNodes();
		printHeading((Element)children.item(1), (Element)children.item(2));
		printBody((Element)children.item(3));
	}
	
	//print the heading of an invoice such as shipping and billing addresses
	public void printHeading (Element e1, Element e2)
	{
		String company;
		String street;
		String city;
		String state;
		String zip;
		
		System.out.println("\n\t\tI N V O I C E\n");
		
		//print shipping address
		NodeList children = e1.getChildNodes();
		
		Element childElement = (Element)children.item(1);
		Text textNode = (Text)childElement.getFirstChild();
		company = textNode.getData();
		
		childElement = (Element)children.item(2);
		textNode = (Text)childElement.getFirstChild();
		street = textNode.getData();
		
		childElement = (Element)children.item(3);
		textNode = (Text)childElement.getFirstChild();
		city = textNode.getData();
		
		childElement = (Element)children.item(4);
		textNode = (Text)childElement.getFirstChild();
		state = textNode.getData();
		
		childElement = (Element)children.item(5);
		textNode = (Text)childElement.getFirstChild();
		zip = textNode.getData();
		
		System.out.println("Ship To:\n" + company + "\n" + street + "\n" + city + ", " + state + " " + zip + "\n");
      
		// print billing address
		children = e2.getChildNodes();

		childElement = (Element)children.item(1);
		textNode = (Text)childElement.getFirstChild();
		company = textNode.getData();

		childElement = (Element)children.item(2);                
		textNode = (Text)childElement.getFirstChild();
		street = textNode.getData();
        
		childElement = (Element)children.item(3);                
		textNode = (Text)childElement.getFirstChild();
		city = textNode.getData();

		childElement = (Element)children.item(4);                
		textNode = (Text)childElement.getFirstChild();
		state = textNode.getData();
        
		childElement = (Element)children.item(5);                
		textNode = (Text)childElement.getFirstChild();
		zip = textNode.getData();

		System.out.println("\nBill To:\n" + company + "\n" + street + "\n" + city + ", " + state + " " + zip + "\n");
	}
	
	//Prints the body of a invoice.
	public void printBody(Element e)
	{
		System.out.println("Description\t\t\tPrice\tQty\tTotal");  
		NodeList children = e.getChildNodes();

		for(int i = 0; i < children.getLength(); i++)
		{
			printItem((Element)children.item(i));
		}

		System.out.println("\nAMOUNT DUE: " + totalAmount);
	}

	
	// Prints all the items in a invoice.
	public void printItem(Element e)
	{
		String description;
		double price;
		int qty;

		NodeList children = e.getChildNodes();
		Element childElement = (Element)children.item(0);
      
		NodeList grandchildren = childElement.getChildNodes();
		Element grandchildElement = (Element)grandchildren.item(0);
		Text textNode = (Text)grandchildElement.getFirstChild();
		description = textNode.getData();

		grandchildElement = (Element)grandchildren.item(1);
		textNode = (Text)grandchildElement.getFirstChild();
		price = Double.parseDouble(textNode.getData());

		childElement = (Element)children.item(1);                
		textNode = (Text)childElement.getFirstChild();
		qty = Integer.parseInt(textNode.getData());

		double total = price * qty;
		totalAmount += total;
		System.out.println(description + "\t\t\t" + price + "\t" + qty + "\t" + total);
	}
}
























