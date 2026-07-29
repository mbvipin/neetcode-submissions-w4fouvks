class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> charMap = new HashMap<>();

        int left=0;
        int res=0;

        for(int right=0; right < s.length(); right++)
        {
            if(charMap.containsKey(s.charAt(right)))
            {
               
                int earlierOccurence= charMap.get(s.charAt(right));
               
               left= Math.max(earlierOccurence+1,left);

                
            }

            charMap.put(s.charAt(right),right);

      

            res= Math.max(res, right- left +1);


        }

        return res;
        
    }
}
