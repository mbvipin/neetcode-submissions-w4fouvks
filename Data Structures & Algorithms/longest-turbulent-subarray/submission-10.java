class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int n = arr.length;

        int res=0;
        int count=0;

        int sign = -1;

        for( int i=0 ; i < n-1; i++)
        {
            if( arr[i] > arr[i+1])
            {
               count = (sign == 0)? count+1 :1;
               sign =1;
            }

            else if( arr[i] < arr[i+1])
            {
                count = (sign == 1)? count +1 :1;
                sign =0;
            }
            else
            {
                count =0;
                sign = -1;
            }

            res= Math.max(res, count);


        }

        return 1+res;
        
    }
}