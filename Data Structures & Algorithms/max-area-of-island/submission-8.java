class DSU
{
    private int [] Parent, Size;

    public DSU( int n)
    {
        Parent= new int [n];
        Size = new int [n];

        for( int i=0 ; i< n; i++)
        {
            Parent[i]=i;
            Size[i]= 1;
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

    public boolean union(int u, int v)
    {
        int pu= find(u);
        int pv= find(v);

        if( pu == pv) return false;

        if( Size[pu] >= Size[pv])
        {
            Size[pu] += Size[pv];
            Parent[pv]= pu;
            return true;

        }

        else
        {
            Size[pv] += Size[pu];
            Parent[pu] = pv;
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

        int [] [] directions = new int [] []
        {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}

        };

        int ROWS= grid.length;
        int COLS= grid[0].length;

        DSU dsu= new DSU(ROWS * COLS);
        int area=0;

        for( int r=0; r < ROWS ; r++)
        {
            for( int c=0; c < COLS; c++)
            {  
                 int currentCentre= r * COLS + c;

             

                if( grid[r] [c] == 1)
                {
                    for (int [] dr: directions)
                    {
                        int newRow= r+ dr[0];
                        int newCol= c+ dr[1];

                        if( newRow >= 0 && newCol >=0 &&
                            newRow < ROWS && newCol < COLS &&
                            grid[newRow][newCol] == 1)
                        {
                            
                            dsu.union( (r * COLS) + c , newRow * COLS + newCol);
                        }

                    }
                    area= Math.max( area, dsu.Size(r * COLS + c));
                }
            }
        }

        return area;
        
    }
}