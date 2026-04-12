class Solution {
    public void sortColors(int[] nums) {

        int[] count= new int [3];

        for( int num: nums)
        {
            count[num]++;
        }

        int index=0;
        for( int color= 0; color < 3; color++)
        {
            for( int k=0 ; k< count[color]; k++)
            {
                nums[index++]=color;
            }
        }


    }

       
}