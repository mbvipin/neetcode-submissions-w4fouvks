class Solution {
    public int climbStairs(int n) {

    Map<Integer,Integer> cache=new HashMap<>();

    return climbStairs(n,0,cache);
   
    }

    public static int climbStairs(int n,int input, Map<Integer,Integer> cache)
    {
        
        if(input == n)
        {
            return 1;
        }

        if( input > n)
        {
            return 0;
        }

        if(cache.containsKey(input+1) && cache.containsKey(input+2))
        {
            return cache.get(input+1) +  cache.get(input+2);
        }


       int resultOneStep=climbStairs(n,input+1,cache);
       int resultTwoStep=climbStairs(n,input+2,cache);

       cache.put(input+1, resultOneStep);
       cache.put(input+2, resultTwoStep);

       return resultOneStep+resultTwoStep;

    }
}
