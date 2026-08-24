class Solution {
    public int[] productExceptSelf(int[] nums) {

        int [] result = new int[nums.length];

        int totalProduct =1;
        int zeroCount=0;
        int totalProductWithoutOneZero=1;

        for(int i=0; i < nums.length; i++)
        {
            totalProduct = totalProduct * nums[i];
            if( nums[i] == 0)
            {
                zeroCount ++;
                continue;
            }

           totalProductWithoutOneZero = totalProductWithoutOneZero * nums[i];

   
        
        }

        for(int i=0; i < nums.length ; i++)
        {
            if( nums[i] == 0)
            {
                result[i]=  zeroCount == 1? totalProductWithoutOneZero :  totalProduct;

            }
            else
            {
            result[i]= totalProduct/nums[i];
            }

        }

        return result;
        
    }
}  
