class Solution {
    public int uniquePaths(int m, int n) {

        if( m== 1 || n==1)
        {
            return 1;
        }

        if( m < n)
        {
            int temp = n;
             n= m;
             m= temp;
        }

        long res= 1;
        int j=1;
        for ( int i= m ; i < m+ n-1 ; i ++)
        {
            res *= i;
            res /= j;

            j++;

        }

        return (int) res;
        
    }
}
