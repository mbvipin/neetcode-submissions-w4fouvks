class Solution {
    public int numIslands(char[][] grid) {

        int ROWS= grid.length;
        int COLS= grid[0].length;

        Set<String> visited= new HashSet<>();

        int numOfIslands= 0;

        for( int i=0; i < ROWS; i++)
        {
            for(int j=0; j< COLS ; j++)
            {
                String point= i+ ","+ j;
                if( grid[i][j] == '1' && !visited.contains(point))
                {
                   dfs(grid,ROWS,COLS,i,j,visited);
                   numOfIslands++;
                }

            }

        }

        return numOfIslands;
        
    }

    private void dfs(char [][] grid,int rowLength,int colLength,
                    int row,int col,
                    Set<String> visited)
    {
        if( row <0 || row >= rowLength || col <0 || col >= colLength)
        {
            return;
        }

        if( grid[row][col] == '0')
        {
            return;
        }

        String point= row+ ","+ col;

        if( visited.contains(point))
        {
            return;
        }

        visited.add(point);

        dfs(grid,rowLength,colLength,row+1,col,visited);
        dfs(grid,rowLength,colLength,row-1,col,visited);
        dfs(grid,rowLength,colLength,row,col+1,visited);
        dfs(grid,rowLength,colLength,row,col-1,visited);

    }
}
