class Solution {
    public int removeDuplicates(int[] nums) {

     int writePointer=1;

     int readPointer=1;

     while( readPointer < nums.length)
     {
        if( nums[readPointer]!= nums[readPointer-1])
        {
            nums[writePointer++]=nums[readPointer];
          
        }

        readPointer++;

     }

     return writePointer;


    }



}