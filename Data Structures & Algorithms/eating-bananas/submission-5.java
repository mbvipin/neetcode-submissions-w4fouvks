class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low=1;
        int high=0;

        int minRate=1;

        for(int pile: piles)
        {
            if( pile > high)
            {
                high=pile;
            }
        }

        while(low <=high)
        {
             int chosen= low+(high-low)/2;

            long timeSpent=0;

            for(int pile: piles)
            {
                timeSpent+=(pile+(chosen-1))/chosen;
            
             }

             if( timeSpent > h)
             {
                low=chosen+1;
             }
             else
             {
                minRate=chosen;
                high=chosen-1;
             }
        }

    return minRate;


    }

}