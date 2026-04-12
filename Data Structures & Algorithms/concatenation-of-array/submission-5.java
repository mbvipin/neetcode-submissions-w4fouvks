class Solution {
    public int[] getConcatenation(int[] nums) {

        if(nums.length == 0)
        {
            return nums;
        }

        int [] result=new int [2* nums.length];

        int k=0;

        for (int i=0; i< 2 ; i++)
        {
         
              for( int j=0; j< nums.length; j++)
              {
                result[k++]=nums[j];
              }

        }

      return result;
    }

}