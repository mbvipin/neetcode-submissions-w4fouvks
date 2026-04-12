class Solution {
    public int removeDuplicates(int[] nums) {

       int countDistinct=1;

       for( int i=1; i< nums.length; i++)
       {
          if(nums[i] == nums[countDistinct-1])
          {
             continue;
          }

          nums[countDistinct++]=nums[i];

       }

       return countDistinct;
        
    }
}