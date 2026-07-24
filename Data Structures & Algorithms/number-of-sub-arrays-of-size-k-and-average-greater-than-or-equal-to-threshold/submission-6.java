class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int target= threshold * k;
        int currSum=0;
        int count=0;

        int L=0;

        for( int R=0; R < arr.length; R++)
        {
            currSum += arr[R];

            if( R >= k-1)
            {
                if(currSum >= target)
                {
                    count += 1;
                }
            
            
            currSum -= arr[R - k+1];
            }

            

        }

        return count;
        
    }
}