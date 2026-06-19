class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int [] inDegree= new int [numCourses];

        List<List<Integer>> preList= new ArrayList<>();

        for(int i=0; i < numCourses; i++)
        {
            preList.add( new ArrayList<>());
        }

        for( int [] prereq: prerequisites)
        {
            int a= prereq[0];
            int b= prereq[1];

             inDegree[a]++;
             preList.get(b).add(a);
        }

        Queue<Integer> toProcess= new LinkedList<>();

        for( int i=0; i< inDegree.length; i++)
        {
            if(inDegree[i] == 0)
            {
                toProcess.offer(i);
            }
        }

        int finished=0;

        while( !toProcess.isEmpty())
        {
            int noPrereq=toProcess.poll();

            finished ++;

            for( int nei : preList.get(noPrereq))
            {
                inDegree[nei]--;

                if(inDegree[nei] == 0)
                {
                    toProcess.offer(nei);
                }


            }


        }

        return finished == numCourses;
        
    }
}
