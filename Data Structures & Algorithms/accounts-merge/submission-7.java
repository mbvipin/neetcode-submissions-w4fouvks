class Solution {

    private List<String> emails= new ArrayList<>();
    private Map<String,Integer> emailIdx= new HashMap<>();
    private Map<Integer,Integer> emailToAcc= new HashMap<>();
    private Map<Integer,List<String>> emailGroup=new HashMap<>();
    private List<List<Integer>> adj;
    private boolean [] visited;


    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        int m=0;

        for(int accId=0; accId < accounts.size(); accId++)
        {
            List<String> account= accounts.get(accId);

            for(int i=1; i < account.size(); i++)
            {
                String email= account.get(i);

                if(!emailIdx.containsKey(email))
                {
                    emailIdx.put(email,m);
                    emailToAcc.put(m,accId);
                    emails.add(email);
                    m++;


                }


            }


        }

        adj= new ArrayList<>();

        for(int i=0; i < m; i++)
        {
            adj.add(new ArrayList<>());
        }

       
            for(List<String> account: accounts)
            {
                for(int i=2; i < account.size(); i++)
                {
                    int emailIdx1= emailIdx.get(account.get(i));
                    int emailIdx2= emailIdx.get(account.get(i-1));

                    adj.get(emailIdx1).add(emailIdx2);
                    adj.get(emailIdx2).add(emailIdx1);
                }

            }


         visited= new boolean[m];

        for(int i=0; i < m; i++)
        {
            if( !visited[i])
            {
                int accId= emailToAcc.get(i);
                emailGroup.putIfAbsent(accId, new ArrayList<>());
                bfs(i,accId);
            }


        }

        List<List<String>> res= new ArrayList<>();

        for(int accId: emailGroup.keySet())
        {
            List<String> emails= emailGroup.get(accId);
            Collections.sort(emails);

            List<String> merged= new ArrayList<>();
            merged.add( accounts.get(accId).get(0));
            merged.addAll(emails);

            res.add(merged);

        }


        return res;


        
    }

    private void bfs(int node, int accId)
    {
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while( !queue.isEmpty())
        {
           int fetched=queue.poll();
           emailGroup.get(accId).add(emails.get(fetched));
          

           for(int nei: adj.get(fetched))
           {
              if(!visited[nei])
              {
                visited[nei] = true;
                queue.offer(nei);
              }

           }


        }



    }
}