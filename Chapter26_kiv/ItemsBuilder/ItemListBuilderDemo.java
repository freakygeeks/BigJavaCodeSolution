//Chapter 26 - Example 26.3

import java.util.ArrayList;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class ItemListBuilderDemo
{
	public static void main (String[] args) throws Exception
	{
		ArrayList<LineItem> items = new ArrayList<LineItem>();
		items.add(new LineItem(new Product("Toaster", 29.95), 3));
		items.add(new LineItem(new Product("Hair Dryer", 24.95), 1));
		
		ItemListBuilder builder = new ItemListBuilder();
		Document doc = builder.build(items);
		DOMImplementation impl = doc.getImplementation();
		DOMImplementationLS implLS = (DOMImplementationLS) impl.getFeature("LS", "3.0");
		LSSerializer ser = implLS.createLSSerializer();
		String out = ser.writeToString(doc);
		
		System.out.println(out);
	}
}