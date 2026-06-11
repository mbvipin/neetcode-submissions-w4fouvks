class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<Integer [] > toProcess= new LinkedList<>();
        int time=0;

        int ROWS = grid.length;
        int COLS= grid[0].length;

        int [][] directions= new int [][]
        {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };


        int fresh=0;


        for( int r=0; r< ROWS; r++)
        {
            for( int c=0 ; c < COLS ; c++)
            {
                if( grid[r][c] == 1)
                {
                    fresh ++;
                }

                 if( grid[r][c] == 2)
                {
                    toProcess.offer(new Integer[]{r,c});
                }


            }


        }

        while( fresh > 0 && !toProcess.isEmpty())
        {
            int size= toProcess.size();

            for( int i= 0; i< size; i++)
            {
                Integer [] polled=toProcess.poll();

                for( int [] direction: directions)
                {
                    int newRow = polled[0]+ direction[0];
                    int newCol= polled[1] +direction[1];

                    if( newRow >= 0 && newRow < ROWS &&
                        newCol >=0 && newCol < COLS &&
                        grid[newRow][newCol] == 1)
                    {
                        grid[newRow][newCol]= 2;
                        toProcess.offer(new Integer[]{newRow,newCol});
                        fresh=fresh-1;
                    }
            
                        
                }

            }
         
           time++;

        }

        return fresh == 0? time: -1;
        
    }
}