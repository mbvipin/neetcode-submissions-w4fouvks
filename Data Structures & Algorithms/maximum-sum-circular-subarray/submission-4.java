class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int n= nums.length;
        int [] rightMax= new int [n];

        int suffixSum= nums[n-1];
        rightMax[n-1]= nums[n-1];

        for( int i= n-2; i >= 0; i--)
        {
            suffixSum += nums[i];
            rightMax[i]= Math.max(rightMax[i+1], suffixSum);
        }

        int maxSum= nums[0];
        int currSum=0;
        int prefixSum=0;

        for( int i= 0; i< n; i++)
        {
            currSum= Math.max(currSum,0)+ nums[i];
            maxSum= Math.max(currSum,maxSum);
            prefixSum += nums[i];
            if( i < n-1)
            {
                maxSum= Math.max( maxSum, prefixSum+rightMax[i+1]);
            }
        }

        return maxSum;
        
    }
}