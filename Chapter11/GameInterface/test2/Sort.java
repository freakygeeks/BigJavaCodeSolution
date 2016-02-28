//  class Sort -- a class containing static sorting methods that can
//                sort any array of Sortable objects

public class Sort {

//  selection sort function

    static void selection_sort(Sortable[] values) {
        int minloc;
        Sortable temp;
        int size = values.length;
        for (int j = 0 ; j < size - 1 ; j++) {
            minloc = j;
            for (int k = j + 1 ; k < size ; k++)
                if (values[k].compare(values[minloc]) < 0)
                    minloc = k;
            if (minloc != j) {
                temp = values[minloc];
                values[minloc] = values[j];
                values[j] = temp;
            }
        }
    }

//  we could add other sorting methods here

}   //  end class Sort

