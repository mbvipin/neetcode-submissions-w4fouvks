class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

      int [] nums1Copy= new int [m];

      for( int i=0; i < m; i++)
      {
        nums1Copy[i]=nums1[i];
      }

      int left= 0;
      int right=0;
      int result=0;

      while( left < nums2.length && right < nums1Copy.length)
      {

        if( nums2[left] < nums1Copy[right])
        {
            nums1[result]=nums2[left];
            left++;
        }
        else
        {
            nums1[result]=nums1Copy[right];
            right++;
        }
       
          result++;

      }

    while( left < nums2.length)
    {
        nums1[result]=nums2[left];
        left++;
        result++;
    }

    while( right < nums1Copy.length)
    {
        nums1[result]=nums1Copy[right];
        right++;
        result++;
    }

      

        
    }
}