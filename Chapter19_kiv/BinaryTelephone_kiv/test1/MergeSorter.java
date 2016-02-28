/**
   This class sorts an array, using the merge sort 
   algorithm
*/
public class MergeSorter
{
   /**
      Constructs a merge sorter.
      @param anItem the array of items to sort
   */
   public MergeSorter(Item[] anItem)
   {
      a = anItem;
   }
   
   /**
      Sorts the array managed by this merge sorter.
      @param from the item to sort from
      @param to the item to sort to
   */
/*   public void sort(int from, int to)
   {  
      if (from >= to) return;
      int mid = (from + to) / 2;
       /* sort the first and the second half */
/*      sort(from, mid);
      sort(mid + 1, to);
      merge(from, mid, to);
   }

   /**
      Merges two sorted arrays into the array to be sorted by this
      merge sorter. 
      @param from the item to sort from
      @param mid the middle of the items
      @param to the item to sort to
   */
/*   private void merge(int from, int mid,
      int to)
   {  
      int n = to - from + 1;
         /* size of the range to be merged */

      /* merge both halves into a temporary vector b */
/*      Item[] b = new Item[n];

      int i1 = from;
         /* next element to consider in the first half */
/*      int i2 = mid + 1;
         /* next element to consider in the second half */
/*      int j = 0; /* next open position in b */

      /* as long as neither i1 nor i2 past the end, move
         the smaller element into b
      */
/*      while (i1 <= mid && i2 <= to)
      { 
         if (a[i1].getKey().compareTo(a[i2].getKey()) < 0)
         { 
            b[j] = a[i1];
            i1++;
         }
         else
         { 
            b[j] = a[i2];
            i2++;
         }
         j++;
      }

      /* note that only one of the two while loops
         below is executed
      */

      /* copy any remaining entries of the first half */
/*      while (i1 <= mid)
      { 
         b[j] = a[i1];
         i1++;
         j++;
      }
      /* copy any remaining entries of the second half */
/*      while (i2 <= to)
      { 
         b[j] = a[i2];
         i2++;
         j++;
      }

      /* copy back from the temporary vector */
/*      for (j = 0; j < n; j++)
         a[from + j] = b[j];
   } 
*/
   
   /**
      Sorts the array managed by this merge sorter
   */
   public void sort()
   {  
      if (a.length <= 1) 
         return;
      Item[] first = new Item[a.length / 2];
      Item[] second = new Item[a.length - first.length];

      System.arraycopy(a, 0, first, 0, first.length);
      System.arraycopy(a, first.length, second, 0, second.length);
      
      MergeSorter firstSorter = new MergeSorter(first);
      MergeSorter secondSorter = new MergeSorter(second);
      firstSorter.sort();
      secondSorter.sort();
      
      merge(first, second);
   }
   
   /**
      Merges two sorted arrays into the array to be sorted by this
      merge sorter. 
      @param first the first sorted array
      @param second the second sorted array
   */
   private void merge(Item[] first, Item[] second)
   {  
      // merge both halves into the temporary array

      int iFirst = 0;
         // next element to consider in the first array
      int iSecond = 0;
         // next element to consider in the second array
      int j = 0; 
         // next open position in a

      // as long as neither iFirst nor iSecond past the end, move
      // the smaller element into a
      while (iFirst < first.length && iSecond < second.length)
      {  
         if (first[iFirst].getKey().compareTo(second[iSecond].getKey()) < 0)
         //if (a[iFirst].getKey().compareTo(a[iSecond].getKey()) < 0)
         {  
            a[j] = first[iFirst];
            iFirst++;
         }
         else
         {  
            a[j] = second[iSecond];
            iSecond++;
         }
         j++;
      }   

      // note that only one of the two while loops
      // below is executed

      // copy any remaining entries of the first array
      System.arraycopy(first, iFirst, a, j, first.length - iFirst);
      
      // copy any remaining entries of the second half
      System.arraycopy(second, iSecond, a, j, second.length - iSecond);
   }   

   private Item[] a;
}
