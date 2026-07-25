class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int target= threshold * k;
        int currSum=0;

        int count=0;

        for( int i=0; i< k-1 ; i++)
        {
            currSum +=  arr[i];
        }

        for( int R= k-1 ; R < arr.length; R++)
        {
            currSum += arr[R];

            if( currSum >= target)
            {
                count +=1;
            }

            currSum -= arr[R - k+1];

        }

        return count;
        
    }
}