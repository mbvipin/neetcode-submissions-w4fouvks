class Solution {
    public int uniquePaths(int m, int n) {

        if( m == 1 || n == 1)
        {
            return 1;
        }

        int r= Math.min(m - 1, n - 1);
        int t= m+n -2;

        int j= 1;
        long res =1;

        for(int i= 1; i <= r; i++)
        {
            res= res * (t - r + i);

            res = res / j;

            j++;

        }

        return (int)res;
    }
}
