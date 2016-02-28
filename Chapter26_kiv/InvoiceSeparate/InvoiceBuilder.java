//Chapter 26 - Exercise 26.17

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
   Builds a DOM document for an invoice that supports both shipping 
   and billing address.
*/
public class InvoiceBuilder
{
   private DocumentBuilder builder;
   private Document doc;
   
   public InvoiceBuilder() throws ParserConfigurationException
   {
      DocumentBuilderFactory factory 
         = DocumentBuilderFactory.newInstance();
      builder = factory.newDocumentBuilder();
   }

   /**
      Builds a DOM document for an invoice.
      @param invoice the invoice
      @return a DOM document describing the invoice
   */
   public Document build(Invoice invoice)
   {
      doc = builder.newDocument();
      Element root = createInvoice(invoice);
      doc.appendChild(root);
      return doc;
   }

   /**
      Builds a DOM element for an invoice
      @param invoice the invoice
      @return a DOM element describing the invoice
   */      
   public Element createInvoice(Invoice invoice)
   {
      Element invoiceElement = doc.createElement("invoice");

      Text numberText = doc.createTextNode(
         "" + invoice.getNumber());
      Element numberElement = doc.createElement("number");
      numberElement.appendChild(numberText);

      Element saddressElement = createAddress(invoice.getShippingAddress(), "shipto");
      Element baddressElement = createAddress(invoice.getBillingAddress(), "billto");
      Element itemsElement = createItemList(invoice.getItems());

      invoiceElement.appendChild(numberElement);
      invoiceElement.appendChild(saddressElement);
      invoiceElement.appendChild(baddressElement);
      invoiceElement.appendChild(itemsElement);
      return invoiceElement;
   }

   /**
      Builds a DOM element for address.
      @param address the address
      @param type the type of address
      @return a DOM element describing the address
   */      
   public Element createAddress(Address address, String type)
   {
      Element addressElement = doc.createElement(type);
      Text nameText = doc.createTextNode(address.getName());
      Element nameElement = doc.createElement("name");
      nameElement.appendChild(nameText);

      Text companyText = doc.createTextNode(address.getCompany());
      Element companyElement = doc.createElement("company");
      companyElement.appendChild(companyText);

      Text streetText = doc.createTextNode(address.getStreet());
      Element streetElement = doc.createElement("street");
      streetElement.appendChild(streetText);

      Text cityText = doc.createTextNode(address.getCity());
      Element cityElement = doc.createElement("city");
      cityElement.appendChild(cityText);

      Text stateText = doc.createTextNode(address.getState());
      Element stateElement = doc.createElement("state");
      stateElement.appendChild(stateText);

      Text zipText = doc.createTextNode(address.getZip());
      Element zipElement = doc.createElement("zip");
      zipElement.appendChild(zipText);

      addressElement.appendChild(nameElement);
      addressElement.appendChild(companyElement);
      addressElement.appendChild(streetElement);
      addressElement.appendChild(cityElement);
      addressElement.appendChild(stateElement);
      addressElement.appendChild(zipElement);
      return addressElement;
   }

   /**
      Builds a DOM element for an array list of items.
      @param items the items
      @return a DOM element describing the items
   */      
   private Element createItemList(ArrayList items)
   {      
      Element itemsElement = doc.createElement("items");
      for (int i = 0; i < items.size(); i++)
      {
         Item anItem = (Item)items.get(i);
         Element itemElement = createItem(anItem);
         itemsElement.appendChild(itemElement);
      }
      return itemsElement;
   }

   /**
      Builds a DOM element for an item.
      @param anItem the item
      @return a DOM element describing the item
   */
   private Element createItem(Item anItem)
   {      
      Element itemElement = doc.createElement("item");
      Element productElement 
         = createProduct(anItem.getProduct());
      Text quantityText = doc.createTextNode(
         "" + anItem.getQuantity());
      Element quantityElement = doc.createElement("quantity");
      quantityElement.appendChild(quantityText);

      itemElement.appendChild(productElement);
      itemElement.appendChild(quantityElement);
      return itemElement;
   }

   /**
      Builds a DOM element for a product.
      @param p the product
      @return a DOM element describing the product
   */
   private Element createProduct(Product p)
   {
      Text descriptionText 
         = doc.createTextNode(p.getDescription());
      Text priceText = doc.createTextNode("" + p.getPrice());

      Element descriptionElement 
         = doc.createElement("description");
      Element priceElement = doc.createElement("price");

      descriptionElement.appendChild(descriptionText);
      priceElement.appendChild(priceText);

      Element productElement = doc.createElement("product");

      productElement.appendChild(descriptionElement);
      productElement.appendChild(priceElement);

      return productElement;
   }
}

