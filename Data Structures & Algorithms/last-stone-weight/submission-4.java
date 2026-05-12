class Solution {
    public int lastStoneWeight(int[] stones) {

        if( stones == null || stones.length == 0)
        {
            return 0;
        }

        Arrays.sort(stones);

        

        int n= stones.length;

        while ( n > 1)
        {
           int highest = stones[n-1];
           int secondHighest= stones[n-2];

           n = n-2;

           int difference = highest- secondHighest;

           if( difference > 0)
           {

           int l= 0;
           int r= n;

           while( l < r)
           {
            int mid = l+ (r-l)/2;

            if(difference > stones[mid])
            {
                l= mid+1;
            }

            else
            {
                r= mid;
            }

           }

           int pos= l;

           n= n+1;

           stones= Arrays.copyOf(stones,n);

           for( int i = n- 1; i > pos; i--)
           {
               stones[i]= stones[i-1];
           } 

           stones[pos]= difference;

           }


        }

        return n > 0? stones[0]:0;
        
    }
}
