class Solution {

    private static final int [][] directions = new int [][]
    {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    private String getPoint( int row, int col)
    {
        return row + "," + col;
    }

    private Integer[] getLoc(int row, int col)
    {
        return new Integer [] {row,col};
    }

    private int bfs( int [] [] grid, int row, int col,int rowLength, int colLength,
               Set<String> visited)
    {
        Queue<Integer[]> toProcess= new LinkedList<>();

        visited.add(getPoint(row,col));
        toProcess.offer(getLoc(row,col));

        int count =1;

        while(!toProcess.isEmpty())
        {
            Integer [] polled= toProcess.poll();

            for(int [] direction: directions)
            {
                int newRow= polled[0]+direction[0];
                int newCol= polled[1]+ direction[1];

                if(newRow >=0 && newRow < rowLength &&
                   newCol >=0 && newCol < colLength
                   && grid[newRow][newCol] == 1
                   && !visited.contains(getPoint(newRow,newCol)))
                {
                   visited.add(getPoint(newRow,newCol));
                   count= count+1;
                   toProcess.offer(getLoc(newRow,newCol));
                }
            }




        }

       return count;

    }




    public int maxAreaOfIsland(int[][] grid) {

        if( grid == null || grid.length == 0)
        {
            return 0;
        }

        int ROWS= grid.length;
        int COLS= grid[0].length;

        Set<String> visited= new HashSet<>();

        int maxArea= 0;

        for( int i= 0; i< ROWS; i++) 
        {
            for( int j=0; j< COLS; j++)
            {
                if( grid[i][j] == 1 && !visited.contains(getPoint(i,j)))
                {
                    int area= bfs(grid,i,j,ROWS,COLS,visited);

                    if( area > maxArea)
                    {
                        maxArea= area;
                    }

                }


            }



        }

        return maxArea;
        
    }
}