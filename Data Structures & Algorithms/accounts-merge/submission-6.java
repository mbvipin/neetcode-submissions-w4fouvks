class Solution {

       private Map<String,Integer> emailIdx= new HashMap<>();
        private List<String> emails= new ArrayList<>();
        private Map<Integer,Integer> emailToAcc= new HashMap<>();
        private List<List<Integer>> adj;
        private Map<Integer,List<String>> emailGroup= new HashMap<>();
        private boolean [] visited;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n= accounts.size();
        int m=0;

        for(int accId=0; accId < accounts.size(); accId++)
        {
            List<String> account= accounts.get(accId);

            for(int i=1; i < account.size(); i++)
            {
                String email= account.get(i);
                if(!emailIdx.containsKey(email))
                {
                    emails.add(email);
                    emailIdx.put(email,m);
                    emailToAcc.put(m,accId);
                    m++;

                }


            }


        }

        adj= new ArrayList<>();

        for(int i=0; i < m; i ++)
        {
            adj.add(new ArrayList<>());
        }

        for(List<String> account: accounts)
        {
            
            for(int i=2; i < account.size(); i++)
            {
                int idx1= emailIdx.get(account.get(i));
                int idx2= emailIdx.get(account.get(i-1));

                adj.get(idx1).add(idx2);
                adj.get(idx2).add(idx1);


            }


        }

         visited= new boolean[m];
        for(int i=0; i < m; i++)
        {
            if(!visited[i] )
            {
                List<String> componentEmails = new ArrayList<>();
                int accId= emailToAcc.get(i);
                emailGroup.put(i, componentEmails);

                bfs(i, componentEmails);


            }


        }

        List<List<String>> res= new ArrayList<>();

        for(int rootNode: emailGroup.keySet())
        {
           List<String> emails= emailGroup.get(rootNode);
           Collections.sort(emails);

           List<String> combined= new ArrayList<>();
           int accId = emailToAcc.get(rootNode);
           combined.add( accounts.get(accId).get(0));
           combined.addAll(emails);

           res.add(combined);


        }

      return res;  
        
    }

    private void bfs(int node, List<String> group)
    {
        visited[node]= true;

        Queue<Integer> queue= new LinkedList<>();
        queue.offer(node);

        group.add(emails.get(node));

        while( !queue.isEmpty())
        {
            int fetched= queue.poll();

            for( int nei: adj.get(fetched))
            {
                if(!visited[nei])
                {
                    visited[nei] = true;
                    group.add(emails.get(nei));
                    queue.offer(nei);
                }

            }


        }


    }
}