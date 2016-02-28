//Chapter8 - Exercise P8.18 version B
//http://www.javaforschool.com/1280095-java-program-to-print-magic-square-matrix/
//http://www.cs.utexas.edu/users/mckinley/305j/lectures/discussion/Spring2007/09D-2Darrays/MagicSquare.java
//http://introcs.cs.princeton.edu/java/14array/MagicSquare.java.html
//http://www.vinaysingh.info/magic-square-test/
//http://www.cs.ucf.edu/~dmarino/ucf/cop3503/sampleprogs/MagicSquare.java
//http://www.mathematische-basteleien.de/magsquare.htm

public class MagicSquares
{
	private int N = 0;
	private int[][] magic;
	
	public MagicSquares(int num)
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
}