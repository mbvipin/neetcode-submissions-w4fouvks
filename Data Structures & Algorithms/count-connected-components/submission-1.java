class UnionFind
{
    private int [] parent;
    private int[] rank;

    public UnionFind(int n)
    {
        parent= new int [n];
        rank= new int [n];
        
        for(int i=0; i < n; i++)
        {
            parent[i]=i;
            rank[i]=1;

        }
    }

    public int find(int x)
    {
        if(x != parent[x])
        {
            parent[x]= find( parent[x]);
        }

        return parent[x];
    }

    public boolean union(int x1, int x2)
    {
        int p1= find(x1);
        int p2= find(x2);

        if( p1 == p2)
        {
            return false;
        }

        if( rank[p1] > rank[p2])
        {
            parent[p2]=parent[p1];
            rank[p1] += rank[p2];
        }
        else
        {
            parent[p1]=parent[p2];
            rank[p2] += rank[p1];
            
        }

        return true;


    }



}


class Solution {
    public int countComponents(int n, int[][] edges) {

        UnionFind uf= new UnionFind(n);

        int res= n;

        for(int [] edge: edges)
        {
            int u= edge[0];
            int v= edge[1];

            if( uf.union(u,v))
            {
                res= res-1;

            }


        }

        return res;

    }
}
