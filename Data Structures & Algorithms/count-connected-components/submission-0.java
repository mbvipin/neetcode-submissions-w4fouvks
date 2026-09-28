class Solution {
    private boolean[] visited;
    private List<List<Integer>> adj;

    public int countComponents(int n, int[][] edges) {

       adj= new ArrayList<>();
        visited= new boolean[n];

        for(int i=0; i < n; i++)
        {
            adj.add(new ArrayList<>());

        }

        for( int [] edge: edges)
        {
            int idx1= edge[0];
            int idx2= edge[1];

            adj.get(idx1).add(idx2);
            adj.get(idx2).add(idx1);
        }

         int res=0;
        for(int i=0; i < n; i++)
        {
            if( !visited[i])
            {
                dfs(i);
                res++;
            }


        }

        return res;

    }

    private void dfs(int i)
    {
        visited[i]= true;

        for(int nei: adj.get(i))
        {
            if(!visited[nei])
            {
                dfs(nei);
            }
        }


    }
}
