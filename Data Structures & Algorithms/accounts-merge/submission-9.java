class UnionFind
{
    private int [] parent;
    private int [] rank;

    public UnionFind(int n)
    {
        parent= new int[n];
        rank= new int [n];

        for(int i=0; i < n ; i++)
        {
            parent[i]=i;
            rank[i]=1;

        }

    }

    public int find(int x)
    {
        if( x != parent[x])
        {
            parent[x]= find( parent[x]);
        }
     
        return parent[x];

    }

    public boolean union(int x1, int x2)
    {
        int p1=find(x1);
        int p2= find(x2);

        if( p1 == p2)
        {
            return false;
        }

        if( rank[p1] > rank[p2])
        {
            parent[p2]= parent[p1];
            rank[p1] += rank[p2];
        }

        else
        {
            parent[p1]= parent[p2];
            rank[p2] += rank[p1];


        }
    
        return true;

    }

}

class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
         int n= accounts.size();

         Map<String,Integer> emailIdx= new HashMap<>();
         UnionFind uf= new UnionFind(n);

         for(int accId=0; accId < accounts.size(); accId++)
         {
            List<String> account= accounts.get(accId);

            for(int j=1; j < account.size(); j++)
            {
                String email= account.get(j);

                if( emailIdx.containsKey(email))
                {
                    uf.union(accId, emailIdx.get(email));
                }
                else
                {
                    emailIdx.put(email,accId);
                }


            }


         }

         Map<Integer,List<String>> emailGroup= new HashMap<>();

         for(Map.Entry<String,Integer> entry: emailIdx.entrySet())
         {
            String email= entry.getKey();
            int accId= entry.getValue();

            int leader= uf.find(accId);

            emailGroup.computeIfAbsent( leader, k -> new ArrayList<>()).add(email);

         }

         List<List<String>> res= new ArrayList<>();

         for(int accId: emailGroup.keySet())
         {
            List<String> emails= emailGroup.get(accId);
            Collections.sort(emails);

            List<String> combined= new ArrayList<>();
            combined.add(accounts.get(accId).get(0));
            combined.addAll(emails);
            res.add(combined);


         }

         return res;

        
    }
}