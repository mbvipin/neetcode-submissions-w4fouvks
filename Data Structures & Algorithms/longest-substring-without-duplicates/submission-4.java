class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left=0;
        int res=0;
   
         Set<Character> charSet= new HashSet<>();

        for( int r=0; r < s.length(); r++)
        {
            while(charSet.contains(s.charAt(r)))
            {

               charSet.remove(s.charAt(left));
               left= left+1;

            }

             charSet.add(s.charAt(r));

           res= Math.max(res, r-left+1);


        }

        return res;
        
    }
}
