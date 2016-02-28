//Chapter 26 - Example 26.3

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ItemListBuilder
{
	private DocumentBuilder builder;
	private Document doc;
	
	public ItemListBuilder() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
	}
	
	//builds a DOM document for an array list of items
	public Document build (ArrayList<LineItem> items)
	{
		doc = builder.newDocument();
		doc.appendChild(createItems(items));
		return doc;
	}
	
	//builds a DOM element for an array list of items
	private Element createItems(ArrayList<LineItem> items)
	{
		Element e = doc.createElement("items");
		
		for (LineItem anItem : items)
		{
			e.appendChild(createItem(anItem));
		}
		return e;
	}
	
	//builds a DOM element for an item
	private Element createItem(LineItem anItem)
	{
		Element e = doc.createElement("items");
		e.appendChild(createProduct(anItem.getProduct()));
		e.appendChild(createTextElement("quantity", "" + anItem.getQuantity()));
		return e;
	}
	
	//builds a DOM element for a product
	private Element createProduct(Product p)
	{
		Element e = doc.createElement("product");
		e.appendChild(createTextElement("description", p.getDescription()));
		e.appendChild(createTextElement("price", "" + p.getPrice()));
		return e;
	}
	
	private Element createTextElement(String name, String text)
	{
		Text t = doc.createTextNode(text);
		Element e = doc.createElement(name);
		e.appendChild(t);
		return e;
	}
}















