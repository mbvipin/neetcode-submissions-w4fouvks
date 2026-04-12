class Solution {
    public void sortColors(int[] nums) {

        int left=0;
        int right= nums.length-1;

        int i=0;

         while( i <= right)
        {
            if(nums[i]== 0)
            {
             swap(nums,i,left);
             left++;
             i++;
          
            }

           else if( nums[i]== 2)
            {
               swap(nums,i, right);
               right--;
            }

            else if( nums[i] == 1)
            {
                i++;
            }


        }

        

    }

    public void swap(int [] arr, int from, int to)
    {
        int temp= arr[to];
        arr[to]= arr[from];
        arr[from]=temp;
    }

       
}