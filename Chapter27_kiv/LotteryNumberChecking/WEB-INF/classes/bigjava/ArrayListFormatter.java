package bigjava;

import java.text.MessageFormat;
import java.util.ArrayList;

/** 
    The ArrayListFormatter formats an array list into an unnumbered HTML list.
*/
public class ArrayListFormatter
{
   /** 
       Formats an array list
       @param aList the list to be formatted
       @return an HTML string that contains the array list
       data as an unnumbered list.
   */
   public StringBuffer format(ArrayList aList)
   {
      StringBuffer buffer = new StringBuffer();
      buffer.append("<ul>");

      for (int i = 0; i < aList.size(); i++)
      {
         buffer.append("<li>");
         buffer.append(aList.get(i).toString());
         buffer.append("</li>");

      }
      buffer.append("</ul>");
      return buffer;
   }
}
