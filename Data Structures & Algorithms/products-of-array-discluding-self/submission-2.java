class Solution {
    public int[] productExceptSelf(int[] nums) {

        int [] result = new int [nums.length];

        int product=1;
        int zeroCount=0;

        for(int num: nums)
        {
            if( num != 0)
            {
                product = product * num;
            }
            else
            {
                zeroCount ++;

            }


        }

        if( zeroCount > 1)
        {
            return new int[ nums.length];
        }

        for(int i=0; i < nums.length; i++)
        {
            if( zeroCount > 0)
            {
                result[i]=nums[i] == 0? product: 0;

            }
            else
            {
                result[i]= product/ nums[i];
            }


        }

        return result;
        
    }
}  
