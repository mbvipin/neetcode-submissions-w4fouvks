class Solution {
    public int findKthLargest(int[] nums, int k) {

        int n= nums.length;
        return partition(nums,0, nums.length-1,n-k);
        
    }

    private int partition(int [] nums,int l, int r, int target)
    {        
        int pivot= r;
        int i= l;

        for(int j= l ; j< r ; j++)
        {
            if(nums[j]<= nums[pivot])
            {
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]= temp;
                i++;
            }
        }

         int temp= nums[i];
         nums[i]= nums[pivot];
         nums[pivot]=temp;

         if( target > i)
         {
              return partition(nums,i+1,r,target);
         }

         else if( target < i)
         {
             return partition(nums,l,i-1,target);
         }
         else
         {
            return nums[i];
         }

      
    }
}