class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int last= m+n-1;
        int right=m-1;
        int left= n-1;


        while( left >=0)
        {
            if(right >=0 && nums1[right] > nums2[left])
            {
                nums1[last]=nums1[right];
                last--;
                right--;
            }
            else
            {
                nums1[last]= nums2[left];
                last--;
                left--;
            }


        }


    }

     
}