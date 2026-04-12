class Solution {
    public int removeDuplicates(int[] nums) {

      int readPointer=1;
      int writePointer=1;

      while( readPointer < nums.length)
      {

        if( nums[readPointer]!= nums[readPointer-1])
        {
            nums[writePointer]=nums[readPointer];
            writePointer++;
        }
          readPointer++;

      }
      
      return writePointer;

    }



}