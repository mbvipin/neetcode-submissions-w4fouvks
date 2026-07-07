class Solution {
    public int uniquePaths(int m, int n) {

        int [][] grid= new int [m][n];
  
       return uniquePaths(m,n,0,0,grid);

    }

    private int uniquePaths(int m, int n, int row, int col,
      int [][] grid)
    {
        if( row > m-1 || col > n-1)
        {
            return 0;
        }

        if( grid[row][col] > 0)
        {
            return grid[row][col];
        }

        if( row == m-1 && col == n-1)
        {
            return 1;
        }

        int count= uniquePaths(m,n,row+1,col,grid)+ uniquePaths(m,n,row,col+1,grid);

        grid[row][col]= count;

        return count;

    }
}
