class Solution {

    private List<List<Integer>> adj;
    private boolean [] visited;

    public int countComponents(int n, int[][] edges) {

        adj= new ArrayList<>();
        visited= new boolean[n];

        for(int i=0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int [] edge: edges)
        {
            int u= edge[0];
            int v= edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);


        }

        int res=0;

        for(int i=0; i < n ; i++)
        {

            if( !visited[i])
            {
                bfs(i);
                res++;
            }


        }

        return res;

    }

    private void bfs(int node)
    {
        visited[node]=true;
        Queue<Integer> queue= new LinkedList<>();

        queue.offer(node);

        while( !queue.isEmpty())
        {
            int fetched= queue.poll();

            for(int nei: adj.get(fetched))
            {
                if(!visited[nei])
                {
                    queue.offer(nei);
                    visited[nei]=true;
                }
            }


        }


    }
}
