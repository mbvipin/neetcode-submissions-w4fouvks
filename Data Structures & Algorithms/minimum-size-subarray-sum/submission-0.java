class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int length= Integer.MAX_VALUE;
        int L =0;
        int total =0;

        for( int R= 0; R < nums.length ; R++)
        {
            total += nums[R];

            while( total >= target)
            {
                length= Math.min(length, R- L +1);
                total -= nums[L];
                 L ++;
            }




        }

        return length == Integer.MAX_VALUE ? 0: length;
        
    }
}