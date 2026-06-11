class Solution {
    public int orangesRotting(int[][] grid) {

        int ROWS= grid.length;
        int COLS =grid[0].length;

        int fresh=0;
        int time=0;

        Queue<Integer []> toProcess= new LinkedList<>();

        for(int i=0; i< ROWS; i++)
        {
            for(int j=0; j< COLS; j++)
            {
                if( grid[i][j] == 1)
                {
                    fresh++;
                }

                if( grid[i][j] == 2)
                {
                    toProcess.offer(new Integer[]{i,j});
                }


            }


        }

        int [][] directions= new int [][]
        {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while( fresh > 0 && !toProcess.isEmpty())
        {
            int size= toProcess.size();

            for (int k=0; k< size; k++)
            {
                Integer [] polled=toProcess.poll();

                for(int [] direction: directions)
                {
                    int newRow= polled[0]+ direction[0];
                    int newCol= polled[1]+ direction[1];

                    if(newRow >=0 && newCol >=0 &&
                      newRow < ROWS && newCol < COLS &&
                      grid[newRow][newCol] == 1)
                    {
                        grid[newRow][newCol] = 2;
                        fresh= fresh-1;
                        toProcess.offer(new Integer[]{newRow,newCol});

                    }

                }


            }

            time++;

        }

        return fresh == 0? time: -1;
        
    }
}
