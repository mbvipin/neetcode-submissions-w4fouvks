class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        Map<String,Integer> cache= new HashMap<>();

        return dfs(text1, text2,0,0,cache);
    }

    private int dfs(String text1,String text2, int i, int j,
    Map<String,Integer> cache)
    {
        if( i == text1.length()|| j == text2.length())
        {
            return 0;
        }

        String key= i+ " "+ j;

        if(cache.containsKey(key))
        {
            return cache.get(key);
        }

         int count =0;
        if( text1.charAt(i) == text2.charAt(j))
        {
           
            count= 1+ dfs(text1,text2, i+1, j+1,cache);
           cache.put(key,count);
           return count;

        }

        else
        {
            int skipText1= dfs(text1,text2,i+1,j,cache);
            int skipText2= dfs(text1,text2,i, j+1,cache);

            count= Math.max(skipText1,skipText2);
            cache.put(key,count);

            return count;

        }


    }
}
