class Solution {
     
     private Map<String,Integer> memo;

    public int maxTurbulenceSize(int[] arr) {

        memo= new HashMap<>();

        int n= arr.length;

        int maxLen=1;

        for(int i=0; i <n; i++)
        {
            maxLen= Math.max(maxLen, dfs(i,true,arr));
            maxLen= Math.max(maxLen,dfs(i,false,arr));
        }

        return maxLen;
        
    }

    private int dfs(int i, boolean sign, int [] arr)
    {
        String key = "i"+ String.valueOf(sign);

        if(memo.containsKey(key))
        {
            return memo.get(key);
        }

        if( i == arr.length-1 )
        {
            return 1;
        }

        int res =1;

        if( (sign && arr[i] > arr[i+1]) ||
            (!sign && arr[i] < arr[i+1]))
        {
  
            res = 1+ dfs(i+1,!sign, arr) ;       
        }

        return res;

    }
}