class Magic{
    public static boolean isMagicSquare(int[][] arr){
        final int n=arr.length;
        final int nSquare=n*n;
        final int M=(n*n*(n*n+1)/2)/n;
        int sumOfRow=0, sumOfColoumns=0, sumOfPrimaryDiagonal=0, sumOfSecondaryDiagonal=0;
        boolean[] flag= new boolean[n*n];
        for(int row=0; row<n; row++){
            sumOfRow=0;
            sumOfColoumns=0;
            for(int col=0; col<n; col++){
                if(arr[row][col]<1 || arr[row][col]>nSquare) return false;
                if(flag[arr[row][col]-1]==true) return false;
                flag[arr[row][col]-1]=true;
                sumOfRow += arr[row][col];
                sumOfColoumns += arr[col][row];
            }
            sumOfPrimaryDiagonal += arr[row][row];
            sumOfSecondaryDiagonal += arr[row][n-row-1];
            if(sumOfRow!=M || sumOfColoumns!=M) return false;
        }
        if(sumOfPrimaryDiagonal!=M || sumOfSecondaryDiagonal!=M) return false;
        return true;
    }
    public static void main(String []args){
        int[][] a ={{4,9,2},
                    {3,5,7},
                    {8,1,6}};
        System.out.println(isMagicSquare(a));
    }
}