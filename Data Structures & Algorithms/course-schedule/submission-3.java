class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int [] inDegree = new int [numCourses];

        List<List<Integer>> adj= new ArrayList<>();

        for( int i=0; i< numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        for( int [] pre: prerequisites)
        {
            inDegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> toProcess= new LinkedList<>();

        for( int i=0; i< numCourses; i++)
        {
            if(inDegree[i] == 0)
            {
                toProcess.add(i);
            }
        }

        int finish=0;

        while( !toProcess.isEmpty())
        {
            int node= toProcess.poll();
            finish++;

            for( int nei : adj.get(node))
            {
                inDegree[nei]--;

                if( inDegree[nei] == 0)
                {
                    toProcess.add(nei);
                }

            }


        }

        return finish == numCourses;
        
    }
}
