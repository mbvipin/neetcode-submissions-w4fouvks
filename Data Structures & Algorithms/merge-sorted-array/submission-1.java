class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int startZeroIndex= m;

        int left=0;
        int right =0;

        while( left < n && right < startZeroIndex)
        {
            if( nums2[left] < nums1[right])
            {
                int temp= nums1[right];
                nums1[right]=nums2[left];
                left++;

                 int rightTracker=right+1;

                 while( rightTracker <= startZeroIndex)
                 {
                    int secondTemp= nums1[rightTracker];
                    nums1[rightTracker]=temp;
                    temp=secondTemp;
                    rightTracker++;
                  
                 }

                 startZeroIndex++;


            }

            right++;

        }

       while( left < n)
       {
        nums1[right]= nums2[left];
        right++;
        left++;
       }

        
    }
}