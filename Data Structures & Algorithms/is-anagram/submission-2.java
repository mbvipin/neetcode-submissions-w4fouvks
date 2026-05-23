class Solution {
    public boolean isAnagram(String s, String t) {

        if( s.length() != t.length())
        {
            return false;
        }

        Map<Character,Integer> input= new HashMap<>();
         Map<Character,Integer> input2= new HashMap<>();
        


        for(int i= 0; i< s.length(); i++)
        {
            if(!input.containsKey(s.charAt(i)))
            {
             input.put(s.charAt(i),1);
            }
            else
            {
                int currentCount=input.get(s.charAt(i));
                input.put(s.charAt(i), ++currentCount);
            }

        }

        for(int i= 0; i< t.length(); i++)
        {
            if(!input2.containsKey(t.charAt(i)))
            {
             input2.put(t.charAt(i),1);
            }
            else
            {
                int currentCount=input2.get(t.charAt(i));
                input2.put(t.charAt(i), ++currentCount);
            }

        }

        for(int i= 0; i< t.length(); i++)
        {
            Integer countTarget= input2.get(t.charAt(i));
            Integer countSource= input.get(t.charAt(i));

            

            if( (countTarget == null) || (countSource == null)
            || (!countTarget.equals(countSource)) )
            {
                return false;
            }
            
        }

        return true;

    }
}