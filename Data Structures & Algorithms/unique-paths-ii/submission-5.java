class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int M= obstacleGrid.length;
        int N= obstacleGrid[0].length;

        int dp [][] = new int [M+1][N+1];

        dp[M-1][N-1] =1;

        for( int r= M-1; r >=0; r--)
        {
           for(int c= N-1; c>=0; c--)
           {
               if(obstacleGrid[r][c] == 1)
               {
                  dp[r][c]= 0;
               }

               else
               {

                 dp[r][c] += dp[r+1][c];
                 dp[r][c] += dp[r] [c+1];


               }


           }


        }

        return dp[0][0];
        
    }
}