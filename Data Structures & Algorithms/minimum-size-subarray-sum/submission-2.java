class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n= nums.length;
        

        int minLength= Integer.MAX_VALUE;


        for( int i=0; i < n ; i++)
        {
            int total=0;
            

            for( int j=i ; j < n; j++)
            {
                total += nums[j];

                if( total >= target)
                {
                    minLength= Math.min(minLength, j- i+1);
                    continue ;
                }
                 
            }



        }

        return minLength == Integer.MAX_VALUE? 0: minLength;
        
    }
}