class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int l=0;
        int count=0;


        for( int r= k-1; r < arr.length; r++)
        {
            int sum=0;

            for(int i =l ; i <= r; i++)
            {
                sum += arr[i];
            }

            int avg = sum/k;

            if( avg >= threshold)
            {
                count += 1;
            }

            l++;


        }

        return count;
        
    }
}