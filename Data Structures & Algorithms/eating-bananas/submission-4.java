class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low=1;
        int high=0;

        for( int pile: piles)
        { 
            if(pile > high)
            {
                high=pile;
            }
        }

        while( low <= high)
        {
            int mid = low + (high - low) / 2;
            long hoursSpent = 0;

            for(int pile: piles)
            {
              hoursSpent += (pile + mid - 1L) / mid;
            }

            if( hoursSpent > h)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return low;
    }
}