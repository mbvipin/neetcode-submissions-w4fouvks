class Solution {

    Map<String,Integer> memo= new HashMap<>();
    public int maxTurbulenceSize(int[] arr) {

        int n= arr.length;
        int maxLen=1;

        for( int i=0; i < n; i++)
        {
            maxLen= Math.max(maxLen, dfs(i,true,arr));
            maxLen= Math.max(maxLen,dfs(i,false,arr));
        }

        return maxLen;
        
    }

    private int dfs( int i, boolean sign,int [] arr)
    {
        int signIndex= sign? 1: 0;
        String memoKey= i + " "+ String.valueOf(sign);

        if( i == arr.length -1)
        {
            return 1;
        }

        if( memo.containsKey(memoKey))
        {
            return memo.get(memoKey);
        }

        int res = 1;

        if( (sign && arr[i] > arr[i+1]) ||
            (!sign && arr[i] < arr[i+1]))
        {
            res= 1+ dfs(i+1,!sign, arr);
        }

        memo.put(memoKey,res);

        return res;

    }


}