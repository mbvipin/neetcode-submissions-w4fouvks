class Solution {
    public void sortColors(int[] nums) {

        int zero=0;
        int one=0;

        for(int two=0 ; two < nums.length; two++)
        {
            int temp =nums[two];

            // 2,1,0
            // 2--> 1
            // 0 -->0
            // 1 -->0

            // 2,2,0
            // 1,2,0

            // 1,2,2
            nums[two]=2;
            
             // 1,2,0
             // 2-->1
             // 1-->1

             //1,1,2
             // 2-->2
             // 1-->2

            if( temp < 2)
            {
                nums[one]=1;
                one++;
            }

             // 0,1,2
             // 0-->2
             // 1-->2
             // 2-->3
             if(temp < 1)
            {
                nums[zero]=0;
                zero++;
            }
        

        }


    }



        
       
}