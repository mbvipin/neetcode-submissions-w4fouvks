class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int res=0;
        int l=0;

        for(int r= k-1; r < arr.length; r++)
        {
            int sum=0;

            for( int i= l; i <=r ; i++)
            {
                sum += arr[i];
            }

            if( sum/k >= threshold)
            {
                res ++;
            }

            l++;


        }

        return res;
        
    }
}