class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxValue=0;

        for( int m=0; m< piles.length; m++)
        {
            if(piles[m]> maxValue)
            {
                maxValue=piles[m];
            }
            
        }
        
        
        int min=maxValue;



        for( int k= 1; k <= maxValue; k++)
        {
            long attempt=0;
            for( int i=0; i < piles.length; i++)
            {
                int given= piles[i];

                 attempt += (given + k - 1L) / k;
            }

            if( attempt <= h)
            {
                min=k;
                break;
            }
        }

        return min;
        
    }
}
