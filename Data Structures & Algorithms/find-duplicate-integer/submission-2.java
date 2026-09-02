class Solution {
    public int findDuplicate(int[] nums) {

        int n= nums.length;

        int [] seen = new int [n];

        for( int num : nums)
        {
            if( seen[num] == 1)
            {
                return num;
            }

            seen[num]=1;

        }

        return -1;
        
    }
}
