class Solution {

    private static final int [] [] directions = new int [] []
    {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };


    public int numIslands(char[][] grid) {

        if( grid == null || grid.length == 0)
        {
            return 0;
        }

        int numberOfIslands= 0;

        int ROWS = grid.length;
        int COLS= grid[0].length;

        Set<String> visited= new HashSet<> ();

        for( int i=0; i< ROWS ; i++)
        {
            for( int j=0 ; j< COLS ; j++)
            {
                if( grid[i][j] == '1' && !visited.contains(getPoint(i,j)))
                {
                    visited.add(getPoint(i,j));
                    bfs(grid,i,j,ROWS,COLS,visited);
                    numberOfIslands ++;

                }
            }
        }

        return numberOfIslands;
        
    }

    private void bfs(char [][] grid,int row, int col,int rowLength, int colLength,
                     Set<String> visited)
    {
        Queue<Integer []> toProcess= new LinkedList<>();
        toProcess.offer(getLoc(row,col));

        while( !toProcess.isEmpty())
        {
            Integer [] polled= toProcess.poll();

            for( int [] direction: directions)
            {
                int newRow= polled[0] + direction[0];
                int newCol= polled[1] + direction[1];

                String neighborPoint=getPoint(newRow,newCol);

                if( newRow >= 0 && newRow < rowLength &&
                   newCol >= 0 && newCol < colLength &&
                   grid[newRow][newCol] == '1' &&
                   !visited.contains(neighborPoint))
                {
                    visited.add(neighborPoint);
                    toProcess.offer(getLoc(newRow,newCol));
                }


            }

        }



    }

                
                     

    private String getPoint(int row,int col)
    {
        return row+ "," + col;
    }

    private Integer[] getLoc(int row,int col)
    {
        return new Integer [] {row,col};
    }
}
