class Solution {
    public int removeElement(int[] nums, int val) {

        // If input is null or empty return 0
        // That means no values were found
        if( nums!=null && nums.length== 0)
        {
            return 0;
        }

        // 2 pointer
        // read pointer traverses the whole array
        // write pointer is updated when number found not equal to val
        // value is read from read pointer and overwrites write pointer

        // if Array is not empty, but no values were found which
        // are not equal to the input value
        // if loop exists straight away 
        int writePointer=0;

        int readPointer=0;

        while( readPointer < nums.length)
        {
            if(nums[readPointer]!=val)
            {
                // replacing val with a non val
                nums[writePointer]=nums[readPointer];
                // move to next position to write
                // If one value is found 0th index is updated
                // And one is returned
                //when a second value is found, 1st index is updated
                // and two ie returned..so on and so forth
                writePointer++;
            }



            // scanning the whole array
            readPointer++;
        }

        


        

       return writePointer;
       
    }

}