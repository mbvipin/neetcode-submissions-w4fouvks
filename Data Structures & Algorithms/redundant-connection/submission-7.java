class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n= edges.length;

        List<List<Integer>> graph= new ArrayList<>();

        for( int i=0; i <=n; i++)
        {
          graph.add(new ArrayList<>());

        }

        int [] inDegree= new int [n+1];

        for( int [] edge: edges)
        {
            int u= edge[0];
            int v= edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            inDegree[u]++;
            inDegree[v]++;
        }

        Queue<Integer> queue= new LinkedList<>();

        for(int i=0; i <= n; i++)
        {
            if(inDegree[i] == 1)
            {
                queue.offer(i);
            }

        }

        while( !queue.isEmpty())
        {
            int node= queue.poll();

            inDegree[node]--;

            for(int nei: graph.get(node))
            {
                inDegree[nei]--;

                if( inDegree[nei] == 1)
                {
                    queue.offer(nei);
                }
            }


        }

        for(int i= edges.length-1; i >=0 ; i--)
        {
            int u= edges[i][0];
            int v= edges[i][1];

            if( inDegree[u] >1 && inDegree[v] > 1)
            {
                return new int [] {u,v};
            }


        }

        return new int[0];
        
    }
}
