class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character,Integer> charMap = new HashMap<>();

        int maxf=0;
        int res=0;

        int l=0;

        for( int r= 0; r < s.length(); r++)
        {
             int newCount=charMap.getOrDefault(s.charAt(r),0)+1;
             charMap.put(s.charAt(r),newCount);

             maxf=Math.max(maxf,newCount);

             while( (r -l +1)- maxf > k)
             {
             int updatedCount=charMap.get(s.charAt(l)) - 1;
             charMap.put(s.charAt(l),updatedCount);
             l++;
             }

             res= Math.max(res, r-l +1);

        }

        return res;
        
    }
}
