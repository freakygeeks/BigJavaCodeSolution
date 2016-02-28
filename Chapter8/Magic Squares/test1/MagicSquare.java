import java.util.*;
import java.io.*;

/**
 * MagicSquare.java
 *
 * Ask a user for the test case file name, and read in each array
 * to see if it is a magic square.
 *
 * @author 1:              discussion section time:
 *
 * @author 2:              discussion section time:
 *
 * @date:
 *
 *
 */


public class MagicSquare
{

    /**
     * isMagic
     *
     * Compute the sums of each column, row and diagonal to see
     * if the given 2-dimensional array is a magic square. If it
     * is, then return true, and if not, then return false;
     *
     * @param array a two dimensional array to test
     *
     * @return boolean true if a magic square
     *                 false if not
     */

    public boolean isMagic ( int[][] magic ) 
	{
       /* int sum=0;
        int lastSum=0;
        boolean magic=true;

        // if the array is not a square then set magic to be false
        for (int i=0; i< array.length; i++) {
            if (array.length!=array[i].length) {
                magic = false;
            }
        }

        // compute the sums of rows and
        // set magic to be false if any of the sums are different
        System.out.print("Sums of rows: ");
        for (int i=0; i < array[0].length; i++) {
            sum=0;
            for (int j=0; j < array.length; j++) {
                //sum+=array[i][j];
				sum = sum + array[i][j];
            }
            System.out.print(sum+" ");
            if (i==0) {
                lastSum=sum;
            } else if (lastSum!=sum) {
                magic = false;
            }
        }
        System.out.println();

		// Here you need to fill in the code to check for the
		// sums of columns and the sums of the diagonals.

        return magic;*/
	int rowSum = 0;
	int lastRowSum = 0;
	int colSum = 0;
	int lastColSum = 0;
	int diagRightSum = 0;
	int addDiagRightSum = 0;
	int diagLeftSum = 0;
	int addDiagLeftSum = 0;
	boolean done = true;
	
	//check if magic length is square
	for (int i = 0; i < magic.length; i++)
		{
		if (magic.length != magic[i].length)
			{
			done = false;
			}
		}
		
	//check sum of row
	System.out.print ("Sum of row : ");
	for (int i = 0; i < magic[0].length; i++)
		{
		rowSum = 0;
		for (int j = 0; j < magic.length; j ++)
			{
			rowSum = rowSum + magic[i][j];//sum of array in row then column
			}
			System.out.print (rowSum + " ");
		
		if (i == 0)
			{
			lastRowSum = rowSum;
			}
		else if (lastRowSum != rowSum)
			{
			done = false;
			}
		}
	System.out.println();	
	
	//check sum of col
	System.out.print ("Sum of col : ");
	for (int i = 0; i < magic[0].length; i++)
		{
		colSum = 0;
		for (int j = 0; j < magic.length; j ++)
			{
			colSum = colSum + magic[j][i]; //sum of array in column then row
			}
			System.out.print (colSum + " ");
		
		if (i == 0)
			{
			lastColSum = colSum;
			}
		else if (lastColSum != colSum)
			{
			done = false;
			}
		}
	System.out.println();	
					
	//check sum of right and left diagonal		
	System.out.print ("Sum of right and left diagonal : ");
	for (int i = 0; i < magic[0].length; i++)
		{
		diagRightSum = 0;
		diagLeftSum = 0;
		for (int j = 0; j < magic.length; j ++)
			{
			if ((i+j) == (magic.length -1)) //check sum of the right diagonal
				{
				diagRightSum = diagRightSum + magic[i][j]; 
				}
			if (i == j) //check sum of the left diagonal
				{
				diagLeftSum = diagLeftSum + magic[i][j]; 
				}
			}
			addDiagRightSum = addDiagRightSum + diagRightSum;
			addDiagLeftSum = addDiagLeftSum + diagLeftSum;
			
			if (addDiagRightSum ==  addDiagLeftSum)
			{
			//System.out.println (addDiagRightSum + " = " + addDiagLeftSum);
			done = true;
			}
			else if (addDiagRightSum !=  addDiagLeftSum)
			{
			done = false;
			}
		}	
	System.out.print (addDiagRightSum + " " + addDiagLeftSum);
	System.out.println();	
	return done;	

    }

    public static void main(String[] args) throws Exception {

        // ask user for the test case file name
        System.out.print("Enter the test case file name: ");
        Scanner stdin = new Scanner(System.in);
        Scanner fs = new Scanner(new File(stdin.nextLine()));

        while (fs.hasNextInt()) {
            // read the array size from the file
            int arraySize = fs.nextInt();
            int[][] xArray = new int[arraySize][arraySize];

            // read the elements of the array from the file
            for (int i=0; i<arraySize; i++) {
                for (int j=0; j<arraySize; j++) {
                    xArray[i][j] = fs.nextInt();
                }
            }

            // print the elements of the array
            for (int i=0; i<arraySize; i++) {
                for (int j=0; j<arraySize; j++) {
                    System.out.print(xArray[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();

            // test if it is a magic square
            MagicSquare ms = new MagicSquare();
            if (ms.isMagic(xArray)) {
                System.out.println("The array is a magic square\n");
            } else {
                System.out.println("The array is not a magic square\n");
            }
        }
    }

}
