class Solution {

      private boolean [] visit;
      private List<List<Integer>> graph;
      int cycleStart;
      Set<Integer> cycle;

    public int[] findRedundantConnection(int[][] edges) {

        int n= edges.length;

        graph = new ArrayList<>();

        for(int i=0; i<=n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int [] edge: edges)
        {
            int u= edge[0];
            int v= edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        cycleStart= -1;
        visit= new boolean[n+1];
        cycle= new HashSet<>();

        dfs(1,-1);

        for(int i= edges.length-1 ; i >=0 ; i--)
        {
            int u= edges[i][0];
            int v= edges[i][1];

            if( cycle.contains(u) && cycle.contains(v))
            {
                return new int [] {u,v};
            }
        }

        return new int [0];
        
    }

    private boolean dfs(int node, int parent)
    {
        if( visit[node])
        {
            cycleStart= node;
            return true;
        }

        visit[node]= true;

        for( int nei: graph.get(node))
        {
            if( nei == parent)
            {
                continue;
            }

            if( dfs(nei,node))
            {
                if(cycleStart != -1)
                {
                cycle.add(node);
                }

                if( cycleStart == node)
                {
                    cycleStart = -1;
                }

                return true;
            }


        }

        return false;


    }
}
