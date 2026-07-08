class Solution {

    private int ROWS;
    private int COLS;
    private Integer[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        ROWS= obstacleGrid.length;
        COLS= obstacleGrid[0].length;
        memo = new Integer[ROWS][COLS];



        return dfs(obstacleGrid,0,0);

        
    }

    private int dfs(int [] [] grid,
    int r, int c)
    {
        if( r >= ROWS || c >= COLS)
        {
            return 0;
        }

        if( grid[r][c] == 1)
        {
            return 0;
        }

        if( r == ROWS -1 && c == COLS -1)
        {
            return 1;
        }

        if( memo[r][c] != null)
        {
            return memo[r][c];
        }



        int count =0;

        count += dfs(grid, r+1, c)+ dfs(grid,r,c+1);

        memo[r][c]= count;

        return count;


    }
}