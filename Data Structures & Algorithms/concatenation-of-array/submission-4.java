class Solution {
    public int[] getConcatenation(int[] nums) {

        if(nums.length == 0)
        {
            return nums;
        }

        int inputLength= nums.length;
        int [] result=new int [ 2 * inputLength];
        
        for(int i=0; i< nums.length; i++)
        {
            result[i]=nums[i];
            result[i+inputLength]=nums[i];
        }

        return result;

    }

}