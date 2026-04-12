class Solution {
    public void sortColors(int[] nums) {

        int zero=0;
        int one=0;
        int two=0;

        for( int i=0 ; i < nums.length; i++)
        {
            if(nums[i]== 0)
            {
                // [1,2,2]
                nums[two]=2;
                // [1,1,2]
                nums[one]=1;
                // [0,1,2]
                nums[zero]=0;

                // two-> 3
                // one -> 2
                // zero--> 1
                two=two+1;
                one=one+1;
                zero=zero+1;
            }

            else if(nums[i]==1)
            {
               // [2,2,0] 
               nums[two]=2;

               // [1,2,0]
               nums[one]=1;

                // one-> 1
                // two-> 2
                two= two+1;
                one= one+1;
            }

            else
            {
                // [2,1,0]
                // two -> 1
                nums[two]=2;
                two=two+1;
            }


        }


    }



        
       
}