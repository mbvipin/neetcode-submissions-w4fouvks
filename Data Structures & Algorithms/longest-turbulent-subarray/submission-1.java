class Solution {

     private int [][] memo;

    public int maxTurbulenceSize(int[] arr) {

        int n= arr.length;
        memo = new int[n][2];

        for(int i=0; i< n; i++)
        {
            memo[i][0]= -1;
            memo[i][1]= -1;
        }

        int maxLen=1;

        for(int i=0; i<n; i++)
        {
            maxLen= Math.max(maxLen, dfs(i,true, arr));
            maxLen= Math.max(maxLen, dfs(i,false, arr));
        }
       
       return maxLen;
    }

    private int dfs(int i, boolean sign, int [] arr)
    {
        int signIndex= sign? 1: 0;

        if( i == arr.length -1)
        {
            return 1;
        }

        if( memo[i][signIndex] != -1)
        {
            return memo[i][signIndex];
        }

        int res=1;

        if( (sign && arr[i] > arr[i+1]) ||
            (!sign && arr[i] < arr[i+1]))
        {
            res = 1+ dfs(i+1, !sign, arr);
        
        }

        memo[i][signIndex]= res;

         return res;
    }
}