//Chapter8 - Exercise P8.18 version A

import java.util.Scanner;

public class MagicSquare
{
	private int N = 0;
	private int [][] magic;
	Scanner in = new Scanner(System.in);
	
	public MagicSquare(int num)
	{
	N = num;
	magic = new int[N][N];
	}
	
	public void addNum ()
	{
	int x = 0;
	int row = N-1;
	int col = N/2;

	for (int i = 0; i < N*N; i++)
		{
		if(magic[(row+1)%N][(col+1)%N] == 0)
			{
			row = (row+1)%N;
			col = (col+1)%N;
			
			//while (magic[(row+1)%N][(col+1)%N] == x || magic[(row-1+N)%N][col] == x)
				{
				System.out.print ("Row " + row + " Col " + col + " : ");
				x = in.nextInt();
				
				System.out.println (x + " has been enter before. Choose another number. ");
				while (x < 1 || x > N*N)
					{
					System.out.print ("Number between 1 until " + N*N + " only. Row " + row + " Col " + col + " : ");
					x = in.nextInt();
					}
				}
			}
		else
			{
			row = (row-1+N)%N;
			//while (magic[(row-1+N)%N][col] == x || magic[(row+1)%N][(col+1)%N] == x)
				{
				System.out.print ("Row " + row + " Col " + col + " : ");
				x = in.nextInt();
			
				System.out.println (x + " has been enter before. Choose another number. ");		
				while (x < 1 || x > N*N)
					{
					System.out.print ("Number between 1 until " + N*N + " only. Row " + row + " Col " + col + " : ");
					x = in.nextInt();
					}
				}
			}
		magic[row][col] = x;
		}	

	for (int a = 0; a < N; a++)
		{
		for (int b = 0; b < N; b++)
			{
			if (magic[a][b] < 10) System.out.print(" ");
			if (magic[a][b] < 100) System.out.print(" ");
			System.out.print(magic[a][b] + " ");
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