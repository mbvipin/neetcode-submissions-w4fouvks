class Solution {
    public int climbStairs(int n) {

        if( n < 3)
        {
            return n;
        }

        int [] track= new int [2];
        track[0]=1;
        track[1]=2;

        for( int i= 2; i < n; i++)
        {
           int temp= track[1];
           //i=2
           //i =3
           // i= 4
           track[1]=track[0]+track[1];

           // 2,3
           // 3.5
           // 5,8
           track[0]=temp;

        }

       return track[1];
   
    }

    
}

