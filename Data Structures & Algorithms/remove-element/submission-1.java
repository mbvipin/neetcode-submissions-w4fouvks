class Solution {
    public int removeElement(int[] nums, int val) {

        int writeIndex=0;
        int readIndex=0;

        while(readIndex < nums.length)
        {
            if(nums[readIndex]!=val)
            {
                nums[writeIndex++]=nums[readIndex];
            }

            readIndex++;

        }

      return writeIndex;

       
    }

}