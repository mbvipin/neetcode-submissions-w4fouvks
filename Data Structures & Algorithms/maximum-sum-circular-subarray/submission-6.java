class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int globalMax= nums[0];
        int currMax= 0;

        int globalMin= nums[0];
        int currMin=0;
        int total =0;

        for( int num: nums)
        {
            currMax = Math.max( currMax+ num, num);
            currMin= Math.min( currMin+ num, num);

            total += num;

            globalMax= Math.max(currMax,globalMax);
            globalMin= Math.min(currMin,globalMin);
        }

       return globalMax > 0? Math.max(total- globalMin,globalMax) : globalMax;
        
    }
}