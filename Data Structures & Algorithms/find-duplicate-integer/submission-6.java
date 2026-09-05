class Solution {
    public int findDuplicate(int[] nums) {

        int n= nums.length;
        int res=0;

        for( int b=0; b < 32; b++)
        {
            int x=0;
            int y=0;
            int mask = 1 << b;

            for(int num: nums)
            {
                if( (num & mask) != 0 )
                {
                    x++;
                }

            }

            for(int i=1; i < n ; i++)
            {
                if( (i & mask) != 0)
                {
                    y++;
                }

            }

            if( x > y)
            {
                res |= mask;
            }


        }

        return res;
        
    }
}
