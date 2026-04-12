class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1, high = 0;
        for (int pile : piles) if (pile > high) high = pile;

        while(low < high)
        {
            int speed = low + (high - low) / 2;
            long totalTime=0;

            for( int pile: piles)
            {
                totalTime+= (pile + speed - 1L) / speed;
            }

            if(totalTime <= h)
            {
                high = speed;
            }
            else
            {
                low = speed + 1;
            }
        }
        return low;
    }
}