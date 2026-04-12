class Solution {
    public int removeElement(int[] nums, int val) {

        if(nums == null || nums.length== 0)
        {
            return 0;
        }

        int readPointer=0;
        int writePointer=0;

        while( readPointer < nums.length)
        {
            if(nums[readPointer]!= val)
            {
                nums[writePointer]=nums[readPointer];
                writePointer++;

            }

            readPointer++;

        }

        return writePointer;
       
    }

}