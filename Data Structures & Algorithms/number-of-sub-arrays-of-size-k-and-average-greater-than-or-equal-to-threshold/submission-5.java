class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int count =0;

        int currSum= 0;

        for( int i= 0; i < k-1 ; i++)
        {
            currSum += arr[i];
        }

        int n= arr.length;

        for( int L= 0; L <= n -k ; L++ )
        {
            currSum += arr[L+ k-1];

            if( currSum/k >= threshold)
            {
                count += 1;
            }
           
           currSum= currSum- arr[L];

        }

        return count;
        
    }
}