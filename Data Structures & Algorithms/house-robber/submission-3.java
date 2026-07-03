class Solution {
    public int rob(int[] nums) {

        Map<Integer,Integer> cache= new HashMap<>();

        return dfs(nums,0,cache);
        
    }

    private int dfs(int [] nums, int i, Map<Integer,Integer> cache)
    {
        if( i >= nums.length)
        {
            return 0;
        }

        if( cache.containsKey(i))
        {
            return cache.get(i);
        }

        int includeCurrent= nums[i]+ dfs(nums,i+2,cache);
        int skipCurrent= dfs(nums,i+1,cache);

        int maxMoney= Math.max(includeCurrent,skipCurrent);

        cache.put(i,maxMoney);

        return maxMoney;

    }
}
