class Solution {
    public int rob(int[] nums) {

        Map<Integer,Integer> cache= new HashMap<>();
        return getMoney(nums,0,cache);
        
    }

    private int getMoney( int [] nums, int i,
        Map<Integer,Integer> cache)
    {
        if( i >= nums.length)
        {
            return 0;
        }

        if( cache.containsKey(i))
        {
            return cache.get(i);
        }

        int skipCurrentHouse= getMoney(nums,i+1,cache);
        int robCurrentHouse= nums[i]+getMoney(nums,i+2,cache);

        int maxForI=Math.max(skipCurrentHouse,robCurrentHouse);

        cache.put(i, maxForI);

        return maxForI;


    }
}
