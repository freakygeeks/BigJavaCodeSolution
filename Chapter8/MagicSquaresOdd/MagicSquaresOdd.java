//Chapter8 - Exercise P8.19

public class MagicSquaresOdd
{
	private int N = 0;
	private int[][] magic;
	
	public MagicSquaresOdd(int num)
	{
	N = num; // let say N is 3
	magic = new int[N][N];
	}
	
	public void addMagic()
	{
	int row = N-1; //3-1 = [2]
    int col = N/2; //3/2 = [1]
    magic[row][col] = 1; //to place num 1 at field [2][1]

    for (int i = 2; i <= N*N; i++) //to iterate from num 2 until num 9
		{
			if (magic[(row + 1) % N][(col + 1) % N] == 0) // magic[row][col] == 0 (means value of array is 0)
			{
				row = (row + 1) % N; //[0] , [1] , [2] = fill-in (ignore), [0] , [1] , [2] , [0]  = fill-in (ignore) , [1] , [2] , [0] 
				col = (col + 1) % N; //[2] , [0] , [1] = fill-in (ignore), [0],  [1] , [2] , [0]  = fill-in (ignore) , [2] , [0] , [1]
				//System.out.println (row + " " + col + " = " + i);
			}
			else 
			{
				row = (row - 1 + N) % N; // don't change col , [0] , [0]
				//System.out.println (row + " " + col + " = " + i + " else ");
			}
    
			magic[row][col] = i; //[2] , [3] , temp [4] (ignore) , else [4] ,[5] , [6] , temp [7] (ignore) , else [7] , [8] , [9]
			//System.out.println();
		}

		// print results
    for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				if (magic[i][j] < 10)  System.out.print(" ");  // for alignment
				if (magic[i][j] < 100) System.out.print(" ");  // for alignment
				System.out.print(magic[i][j] + " ");
			}
    
		System.out.println();
		}
	}
	
	public boolean isMagic()
	{
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
}