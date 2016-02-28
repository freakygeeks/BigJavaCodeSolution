/**
   A class for executing binary searches through an array.
*/
public class BinarySearcher
{  
   /**
      Constructs a BinarySearcher.
      @param anItem a sorted array of items
   */
   public BinarySearcher(Item[] anItem)
   {
      v = anItem;
   }
   
   /**
      Finds a value in a sorted array, using the binary
      search algorithm.
      @param from the number to search from
      @param to the number to search to
      @param a the string to search
      @return the index at which the value occurs, or -1
      if it does not occur in the array
   */
   public int binarySearch(int from,
      int to, String a)
   { 
      if (from > to)
         return -1;
      int mid = (from + to) / 2;
      int diff = v[mid].getKey().compareTo(a);
      if (diff == 0) /* v[mid] == a */
         return mid;
      else if (diff < 0) /* v[mid] < a */
         return binarySearch(mid + 1, to, a);
      else
         return binarySearch(from, mid - 1, a);
   }

   private Item[] v;
}
