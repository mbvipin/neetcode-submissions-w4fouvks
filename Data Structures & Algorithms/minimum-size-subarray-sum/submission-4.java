class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n= nums.length;

        int [] prefixSum= new int [n+1];

        for( int i=0; i< n; i++)
        {
            prefixSum[i+1]= prefixSum[i]+ nums[i];
        }

        int res= Integer.MAX_VALUE;

        for( int i=0; i< n; i++)
        {
            int l= i;
            int r= n;

            while( l < r)
            {


                int mid= (l+ r)/2;

                int currSum= prefixSum[mid+1]- prefixSum[i];

                if(target <= currSum)
                {
                    r =mid;
                }
                else
                {
                    l= mid+1;
                }


             }

             if( l != n)
             {
                res= Math.min(res, l- i+1);
             }

        }

          return res == Integer.MAX_VALUE? 0: res;
        
    }
}