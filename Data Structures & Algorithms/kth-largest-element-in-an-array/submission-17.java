class Solution {
    public int findKthLargest(int[] nums, int k) {

        return quickSelect(nums,nums.length-k);
        
    }

    private int quickSelect(int [] nums, int target)
    {
        int left= 0;
        int right= nums.length -1;

        while(true)
        {
            if( right <= left +1 )
            {
                if( right == left +1 && nums[right] < nums[left])
                {
                    swap(nums,left,right);
                    
                }

                return nums[target];

            }

            int j= partition(nums,left,right);

            if( target > j)
            {
                left= j+1;
            }

            else if( target <= j)
            {
                right= j-1;
            }



        }


    }

    private int partition(int [] nums,int left,int right)
    {
        int mid =(left+ right) >> 1;

        swap(nums,left+1,mid);

        if( nums[right] < nums[left])
        {
            swap(nums,left,right);
        }

        if( nums[right] < nums[left+1])
        {
            swap(nums,left+1, right);
        }

        if(nums[left+1] < nums[left])
        {
            swap(nums,left+1, left);
        }

        int i= left+1;
        int pivot= nums[left+1];
        int j= right;

        while(true)
        {
        while( nums[++i] < pivot)
        {

        }

        while(nums[-- j] > pivot)
        {

        }

        if( i > j)
        {
            break;
        }
        
          swap(nums,i,j);
        }

          nums[left+1]=nums[j];
          nums[j]=pivot;

        return j;



    }

    private void swap(int [] nums,int from, int to)
    {
        int temp= nums[to];
        nums[to]= nums[from];
        nums[from]=temp;


    }
}
