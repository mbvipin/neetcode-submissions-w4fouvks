class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int L=0;
        int sum=0;
        int avg=0;

         int count=0;

         for(int R=0; R < arr.length; R++)
         {
            sum += arr[R];

            if( R- L+ 1 == k)
            {
                avg= sum/k;

                if( avg >= threshold)
                {
                    count = count+1;
                }

              sum = sum- arr[L];
              L= L+1;


            }



         }

         return count;
        
    }
}