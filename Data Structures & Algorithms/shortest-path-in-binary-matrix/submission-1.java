class Solution {

      private Integer[] getLoc( int row, int col)
      {
        return new Integer [] {row,col};
      }

      private String getPoint(int row, int col)
      {
        return row + "," + col;
      }



    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;

        int ROWS = grid.length;
        int COLS= grid[0].length;

        Set<String> visited = new HashSet<>();

        int [][] directions = new int [][]
        {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
            {-1,-1},
            {-1, 1},
            {1,-1},
            {1,1}
        };

        Queue<Integer [] > toProcess = new LinkedList<>();
        visited.add(getPoint(0,0));
        toProcess.offer(getLoc(0,0));
        int length=1;

        while(!toProcess.isEmpty())
        {
            int size = toProcess.size();
            for (int q = 0; q < size; q++) {
                Integer[] polled= toProcess.poll();

                if(polled[0] == ROWS-1 && polled[1] == COLS-1)
                {
                    return length;
                }

                for(int [] dir: directions)
                {
                    int newRow =polled[0] + dir[0];
                    int newCol= polled[1] + dir[1];

                    String newPoint = getPoint(newRow,newCol);
                    Integer [] newLoc= getLoc(newRow, newCol);

                    if( newRow >=0 && newCol >= 0 &&
                        newRow < ROWS && newCol < COLS &&
                        grid[newRow][newCol] == 0 &&
                        !visited.contains(newPoint)
                        )
                    {
                        toProcess.offer(newLoc);
                        visited.add(newPoint);
                    }
                }
            }
            length= length+1;
        }

        return -1;
    }
}