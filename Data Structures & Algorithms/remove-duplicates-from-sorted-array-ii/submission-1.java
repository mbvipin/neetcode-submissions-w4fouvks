class Solution {
    public int removeDuplicates(int[] nums) {

        int n= nums.length;

        int i=0;

        while ( i < n-1)
        {

            if( nums[i] == nums[i+1])
            {
                int j= i+2;
                int count=0;

                while( j < n && nums[i] == nums[j])
                {
                    count++;
                    j++;
                }

                for( int k= i+2; k< n; k ++)
                {
                    if( j >= n) break;
                    nums[k] = nums[j++];
                }

                n= n- count;
                i= i+2;

            }
            else
            {
                i++;
            }



        }

        return n;
        
    }
}