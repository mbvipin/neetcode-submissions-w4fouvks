class Solution {
    public int characterReplacement(String s, int k) {

        int res=0;

        for( int i=0; i < s.length(); i++)
        {
            Map<Character,Integer> charMap= new HashMap<>();
            int maxf=0;

            for(int j=i ; j < s.length(); j++)
            {
                char currentChar= s.charAt(j);
                int newCount=charMap.getOrDefault(currentChar,0)+1;
                
                charMap.put(currentChar,newCount);

                maxf= Math.max(maxf, newCount);

                int rangeLength= j- i+1;

                if(rangeLength - maxf <= k)
                {
                    res= Math.max(res, rangeLength);
                }

            }



        }

        return res;
        
    }
}
