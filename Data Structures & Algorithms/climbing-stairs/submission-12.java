class Solution {
    public int climbStairs(int n) {

     Map<Integer,Integer> cache= new HashMap<>();

     return climbStairs(n, cache);

    
    }

    public int climbStairs(int n, Map<Integer,Integer> cache)
    {
        if( n <=1)
        {
            return 1;
        }

        if( cache.containsKey(n))
        {
            return cache.get(n);
        }

        int result=climbStairs(n-1,cache)+climbStairs(n-2,cache);

        cache.put(n,result);

        return result;


    }
       
}
