//Chapter 26 - Exercise 26.9

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
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.Rectangle;

public class RectangularShapeParser
{
	private DocumentBuilder builder;
	
	public RectangularShapeParser() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
	}
	
	//parses an XML file containing a RectangularShape
	public Shape parse(String fileName) throws SAXException, IOException
	{
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		//get the <rectangularshape> element
		return getRectangularShape(doc.getDocumentElement());
	}
	
	//get the RectangularShape object
	public Shape getRectangularShape(Element e)
	{
		Shape s = null;
		
		if (e.getAttribute("shape").equals("rectangular"))
		{
			s = (Shape)createRectangle(e);
		}
		else if (e.getAttribute("shape").equals("ellipse"))
		{
			s = (Shape)createEllipse(e);
		}
		else if (e.getAttribute("shape").equals("diamond"))
		{
			s = (Shape)createDiamond(e);
		}
		
		return s;
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
	
	//create an ellipse object
	private Ellipse2D.Double createEllipse(Element e)
	{
		NodeList children = e.getChildNodes();
		double x = 0;
		double y = 0;
		double width = 0;
		double height = 0;
		
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
					x = Double.parseDouble(textNode.getData());
				}
				else if (tagName.equals("y"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					y = Double.parseDouble(textNode.getData());
				}
				else if (tagName.equals("width"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					width = Double.parseDouble(textNode.getData());
				}
				else if (tagName.equals("height"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					height = Double.parseDouble(textNode.getData());
				}
			}
		}
		return new Ellipse2D.Double(x, y, width, height);
	}
	
	//create a diamond shape object
	private Shape createDiamond (Element e)
	{
		NodeList children = e.getChildNodes();
		float x = 0;
		float y = 0;
		float width = 0;
		float height = 0;
		
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
					x = Float.parseFloat(textNode.getData());
				}
				else if (tagName.equals("y"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					y = Float.parseFloat(textNode.getData());
				}
				else if (tagName.equals("width"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					width = Float.parseFloat(textNode.getData());
				}
				else if (tagName.equals("height"))
				{
					Text textNode = (Text)childElement.getFirstChild();
					height = Float.parseFloat(textNode.getData());
				}
			}
		}
		
		GeneralPath diamond = new GeneralPath();
		diamond.moveTo(width/2, 0);
		diamond.lineTo(width, height/2);
		diamond.lineTo(width/2, height);
		diamond.lineTo(0, height/2);
		diamond.closePath();
		return diamond;
	}
}

















