//  class IntNum -- a class for Sortable ints

public class IntNum implements Sortable {
    private int theNum;     //  field to hold the integer

    public IntNum() {
        theNum = 0;
    }

    public IntNum(int number) {
        theNum = number;
    }

//  compare function required by Sortable interface

    public int compare(Sortable another) {
        return ((IntNum)this).theNum - ((IntNum) another).theNum;
    }

//  allows us to print an IntNum

    public String toString() {
        return Integer.toString(theNum);
    }
}	//  end class IntNum

