class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minLength= Integer.MAX_VALUE;
        int total=0;
        

        int L=0;

        for(int R=0 ; R < nums.length; R++)
        {
            total += nums[R];

      

            while( total >= target)
            {
            
             minLength= Math.min(minLength,R - L+1);
             total -= nums[L];


             L++;

            }

    



        }

        return minLength == Integer.MAX_VALUE? 0: minLength;
        
    }
}