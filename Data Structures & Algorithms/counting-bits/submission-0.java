class Solution {
    public int[] countBits(int n) {

       int [] res= new int [n+1];

       for( int i= 0; i <= n; i++)
       {
           res[i]= count(i);

       }

       return res;

        
    }

    private int count( int input)
    {
        int count =0;

        while( input != 0)
        {

            if( (input & 1) == 1)
            {
                count= count+1;
            }
          
           input = input >>> 1;

        }

        return count;


    }
}
