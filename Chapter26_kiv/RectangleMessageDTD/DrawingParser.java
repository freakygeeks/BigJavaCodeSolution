//Chapter 26 - Exercise 26.11

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
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;

public class DrawingParser
{
	private DocumentBuilder builder;
	
	public DrawingParser() throws ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setIgnoringElementContentWhitespace(true);
		builder = factory.newDocumentBuilder();
	}
	
	//parses an XML file containing a drawing
	public ArrayList parse (String fileName) throws SAXException, IOException
	{
		File f = new File(fileName);
		Document doc = builder.parse(f);
		
		//get the <drawing> element
		return getDrawingList(doc.getDocumentElement());
	}
	
	//get the drawing object
	public ArrayList getDrawingList(Element e)
	{
		ArrayList drawingList = new ArrayList();
		NodeList children = e.getChildNodes();
		
		for (int i = 0; i < children.getLength(); i++)
		{
			Element childElement = (Element)children.item(i);
			
			if (childElement.getTagName().equals("rectangle"))
			{
				addRectangle(drawingList, childElement);
			}
			else if (childElement.getTagName().equals("line"))
			{
				addLine(drawingList, childElement);
			}
			else if (childElement.getTagName().equals("message"))
			{
				addMessage(drawingList, childElement);
			}
		}
		
		return drawingList;
	}
	
	//adds a rectangle object to the drawing list
	private void addRectangle (ArrayList drawingList, Element e)
	{
		NodeList children = e.getChildNodes();
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		
		Element childElement = (Element)children.item(0);
		Text textNode = (Text)childElement.getFirstChild();
		x = Integer.parseInt(textNode.getData());
		
		childElement = (Element)children.item(1);
		textNode = (Text)childElement.getFirstChild();
		y = Integer.parseInt(textNode.getData());
		
		childElement = (Element)children.item(2);
		textNode = (Text)childElement.getFirstChild();
		width = Integer.parseInt(textNode.getData());
		
		childElement = (Element)children.item(3);
		textNode = (Text)childElement.getFirstChild();
		height = Integer.parseInt(textNode.getData());
		
		drawingList.add(new Rectangle(x, y, width, height));
	}
	
	//add a line object to the drawing list
	private void addLine (ArrayList drawingList, Element e)
	{
		NodeList children = e.getChildNodes();
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		Element childElement = (Element)children.item(0);
		Text textNode = (Text)childElement.getFirstChild();
		x1 = Integer.parseInt(textNode.getData());
		
		childElement = (Element)children.item(1);
		textNode = (Text)childElement.getFirstChild();
		y1 = Integer.parseInt(textNode.getData());
		
		childElement = (Element)children.item(2);
		textNode = (Text)childElement.getFirstChild();
		x2 = Integer.parseInt(textNode.getData());
		
		childElement = (Element)children.item(3);
		textNode = (Text)childElement.getFirstChild();
		y2 = Integer.parseInt(textNode.getData());
		
		GeneralPath line = new GeneralPath();
		line.moveTo(x1, y1);
		line.moveTo(x2, y2);
		drawingList.add(line);
	}
	
	//add a message object to the drawing list
	private void addMessage (ArrayList drawingList, Element e)
	{
		NodeList children = e.getChildNodes();
		int x = 0;
		int y = 0;
		String text = null;
		
		Element childElement = (Element)children.item(0);
		Text textNode = (Text)childElement.getFirstChild();
		text = textNode.getData();
		
		childElement = (Element)children.item(1);
		textNode = (Text)childElement.getFirstChild();
		x = Integer.parseInt(textNode.getData());
		
		childElement = (Element)children.item(2);
		textNode = (Text)childElement.getFirstChild();
		y = Integer.parseInt(textNode.getData());
		
		drawingList.add(new Message(text, x, y));
	}
}















