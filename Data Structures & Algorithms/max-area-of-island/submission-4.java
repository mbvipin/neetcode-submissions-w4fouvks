class DSU
{
    private int [] Parent,Size;

    public DSU(int n)
    {
        Parent = new int[n+1];
        Size= new int[n+1];

        for(int i= 0; i<=n; i++)
        {
            Parent[i]= i;
            Size[i] = 1;
        }

    }

    public int find( int node)
    {
        if( node != Parent[node])
        {
           Parent[node]= find(Parent[node]);
        }

        return Parent[node];

    }

    public boolean union( int u,int v)
    {
        int pu= find(u);
        int pv= find(v);

        if( pu == pv) return false;

        if(Size[pu] >= Size[pv])
        {
            Size[pu]+= Size[pv];
            Parent[pv]= Parent[pu];
            
            return true;
        }
        else
        {
            Size[pv] += Size[pu];
            Parent[pu]= Parent[pv];

            return true;


        }


    }

    public int Size(int node)
    {
        return Size[find(node)];
    }


}



class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int [][] directions = new int [][]
        {
            {1,0},
            {-1,0},
            {0, 1},
            {0, -1}
        };

        int ROWS= grid.length;
        int COLS= grid[0].length;

        DSU dsu= new DSU( ROWS * COLS);

        int area=0;

        for( int i= 0; i< ROWS ; i++)
        {
            for( int j=0; j< COLS; j++)
            {System.out.println(i + " " + j);
                if( grid[i][j] == 1)
                {
                    for(int[] dir: directions)
                    {
                        int newRow= i+ dir[0];
                        int newCol= j+ dir[1];

                        if( newRow >= 0 && newCol >= 0 &&
                           newRow < ROWS && newCol < COLS &&
                           grid[newRow][newCol] == 1)
                        {
                            dsu.union(i * COLS + j, newRow * COLS + newCol);



                        }


                    }
                  
                   area= Math.max(area, dsu.Size( i * COLS + j));

                }



            }


        }

    return area;
        
    }
}