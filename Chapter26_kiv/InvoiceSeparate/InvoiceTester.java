//Chapter 26 - Exercise 26.17

import java.util.ArrayList;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
   This program tests the invoice builder. It prints the
   XML file corresponding to a DOM document containing an 
   invoice. The invoice supports separate shipping and
   billing addresses.
*/
public class InvoiceTester
{
   public static void main(String[] args) throws Exception
   {
      Address shippingAddress = new Address("Sam John", "Sam's Small Appliances", "100 Main Street", "Anytown", "CA", "98765");

      Address billingAddress = new Address("Cay Horstmann", "Sam's Small Appliances","100 Senter Road", "San Jose", "CA", "95109");

      Invoice samsInvoice = new Invoice(11138, shippingAddress, billingAddress);
      samsInvoice.add(new Product("Toaster", 29.95), 3);
      samsInvoice.add(new Product("Hair dryer", 24.95), 1);
      samsInvoice.add(new Product("Car vacuum", 19.99), 2);

      
      InvoiceBuilder builder = new InvoiceBuilder();
      Document doc = builder.build(samsInvoice);         
      Transformer t = TransformerFactory.newInstance().newTransformer();
      t.transform(new DOMSource(doc), new StreamResult(System.out));
   }
}
