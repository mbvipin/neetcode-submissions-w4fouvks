class Solution {
    public int maxSubArray(int[] nums) {
    
        if( nums.length == 0)
        {
            throw new RuntimeException("invalid input");
        }

        int maxSum= nums[0];
        int currSum= 0;

       for(int num: nums)
       {
          
        currSum= Math.max(currSum,0);
        currSum= currSum+num;
        maxSum= Math.max(currSum,maxSum);
       }

       return maxSum;

        
    }
}
