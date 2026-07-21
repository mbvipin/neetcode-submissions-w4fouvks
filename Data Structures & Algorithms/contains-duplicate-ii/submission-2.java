class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> trackIndex = new HashMap<>();

        for( int i=0; i< nums.length; i++)
        {
            int currentNum= nums[i];
            if( trackIndex.containsKey(currentNum)
               && (i - trackIndex.get(currentNum)  <= k))
            {
                return true;
            }

            trackIndex.put(currentNum,i);
        }

        return false;
        
    }
}