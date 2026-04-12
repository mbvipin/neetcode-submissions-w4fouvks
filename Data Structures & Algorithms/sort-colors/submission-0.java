class Solution {
    public void sortColors(int[] nums) {

        int [] count= new int [3];

        for( int i=0 ; i< count.length; i++)
        { 
            count[i]=0;
        }

        for(int i=0; i< nums.length; i++)
        {
            int existingCount= count[nums[i]];
            count[nums[i]]=++existingCount;

        }

        int k = 0;
        for(int i=0 ; i < 3; i++)
        {
            int availableCount= count[i];

            while(availableCount > 0)
            {
                nums[k]=i;
                k++;
                availableCount --;
            }
        }
    }
}