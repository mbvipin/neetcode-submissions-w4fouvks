class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n= edges.length;

        int [] par = new int [n+1];
        int [] rank= new int [n+1];

        for(int i=1; i <= n; i++)
        {
            par[i]=i;
            rank[i]=1;
        }

        for(int [] edge: edges)
        {
            int u= edge[0];
            int v= edge[1];

            if( ! union(u,v,par,rank))
            {
                return new int [] {u,v};
            }
        }

        return new int[0];
        
    }

    public int find(int n,int [] par)
    {
        int p= par[n];

        while( p != par[p])
        {
            p= par[par[p]];
        }

        return p;
    }

    public boolean union(int u, int v,int [] par,int [] rank)
    {
        int p1= find(u,par);
        int p2= find(v,par);

        if( p1 == p2)
        {
            return false;
        }

        if( rank[p1] > rank[p2])
        {
            par[p2]=p1;
            rank[p1]++;
        }
        else
        {
            par[p1]=p2;
            rank[p2]++;
        }

        return true;

    }
}
