class Solution {

     private static final int [][] directions = new int [][]
     {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
     };

     private String getPoint(int row,int col)
     {
        return row + "," + col;
     }

    public int maxAreaOfIsland(int[][] grid) {

        if( grid == null || grid.length == 0)
        {
            return 0;
        }

        int maxArea=0;
        int ROWS= grid.length;
        int COLS= grid[0].length;

        Set<String> visited= new HashSet<> ();

        for( int i=0; i< ROWS; i++)
        {
            for(int j=0 ; j< COLS; j++)
            {
                if( grid[i][j] == 1 && !visited.contains(getPoint(i,j)))
                {
                   
                    int area=dfs(grid,i,j, ROWS,COLS,visited);

                    if( area > maxArea)
                    {
                        maxArea= area;
                    }

                }


            }


        }

        return maxArea;
        
    }

    private int dfs ( int [][] grid, int row, int col, int rowLength,
                      int colLength,Set<String> visited)
    {
        if( row < 0 || row >= rowLength || col < 0
               || col >= colLength
               || grid[row][col] == 0
               || visited.contains(getPoint(row,col)))
               {  
                return 0;
               }
        visited.add(getPoint(row,col));
        int count= 1;
        for( int [] direction: directions)
        {
            int newRow= row+ direction[0];
            int newCol= col + direction[1];
  
            count += dfs( grid, newRow, newCol,rowLength,colLength,visited);
            
        }
     
       return count;

    }
}