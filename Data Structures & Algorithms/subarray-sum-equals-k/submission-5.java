class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> prefixSums= new HashMap<>();

        int res=0;
        prefixSums.put(0,1);

        int currSum=0;

        for(int num: nums)
        {
            currSum += num;

            int diff= currSum-k;

            res += prefixSums.getOrDefault(diff,0);

            prefixSums.put(currSum, prefixSums.getOrDefault(currSum,0)+1);
        }

        return res;
        
    }
}