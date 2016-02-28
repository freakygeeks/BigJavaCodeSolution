//Chapter 26 - Exercise 26.7

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
import java.awt.Rectangle;

public class RectangleParser
{
	private DocumentBuilder builder;
	
	public RectangleParser() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
	}
	
	//parses an XML file containing a rectangle
	public Rectangle parse (String fileName) throws SAXException, IOException
	{
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		//get the <rectangle> element
		
		return getRectangle(doc.getDocumentElement());
	}
	
	//get the rectangle object
	public Rectangle getRectangle (Element e)
	{
		Rectangle r = null;
		
		if (e.getTagName().equals("rectangle"))
		{
			r = createRectangle(e);
		}
		
		return r;
	}
	
	//create a rectangle object
	private Rectangle createRectangle (Element e)
	{
		NodeList children = e.getChildNodes();
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		
		for (int j = 0; j < children.getLength(); j++)
		{
			Node childNode = children.item(j);
			
			if (childNode instanceof Element)
			{
				Element childElement = (Element)childNode;
				String tagName = childElement.getTagName();
				
				if (tagName.equals("x"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					x = Integer.parseInt(textNode.getData());
				}
				else if (tagName.equals("y"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					y = Integer.parseInt(textNode.getData());
				}
				else if (tagName.equals("width"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					width = Integer.parseInt(textNode.getData());
				}
				else if (tagName.equals("height"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					height = Integer.parseInt(textNode.getData());
				}
			}
		}
		
		return new Rectangle(x, y, width, height);
	}
}














