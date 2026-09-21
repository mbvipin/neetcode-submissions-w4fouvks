class Solution {

    private Map<String,Integer> emailIdx= new HashMap<>();
    private List<String> emails= new ArrayList<>();
    private Map<Integer,Integer> emailToAcc= new HashMap<>();
    private List<List<Integer>> adj;
    private Map<Integer,List<String>> emailGroup= new HashMap<>();
    private boolean [] visited;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        int m=0;

        for(int accId=0; accId < n; accId++)
        {
            List<String> account= accounts.get(accId);

            for(int i=1; i < account.size(); i++)
            {
                String email= account.get(i);
                
                if( !emailIdx.containsKey(email))
                {
                    emails.add(email);
                    emailIdx.put(email,m);
                    emailToAcc.put(m,accId);
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
                int id1= emailIdx.get(account.get(i));
                int id2= emailIdx.get(account.get(i-1));

                adj.get(id1).add(id2);
                adj.get(id2).add(id1);


            }


        }

        visited = new boolean[m];

        for(int i=0; i <m; i++)
        {
            if( ! visited[i])
            {
                int accId= emailToAcc.get(i);
                emailGroup.putIfAbsent(accId,new ArrayList<>());
                dfs(i,accId);
            }

        }

        List<List<String>> res= new ArrayList<>();

        for(int accId: emailGroup.keySet())
        {
            List<String> group= emailGroup.get(accId);
            Collections.sort(group);
            List<String> merged= new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(group);
            res.add(merged);


        }

        return res;


        
    }

    private void dfs(int node,int accId)
    {
        visited[node]= true;
        emailGroup.get(accId).add(emails.get(node));

        for(int nei: adj.get(node))
        {
            if(!visited[nei])
            {
                dfs(nei,accId);
            }
        }


    }
}