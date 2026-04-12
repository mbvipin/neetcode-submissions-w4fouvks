class Solution {
    public boolean isValid(String s) {

        Map<Character,Character> symbolMap=new HashMap<>();

        symbolMap.put(')','(');
        symbolMap.put(']','[');
        symbolMap.put('}','{');

        Stack<Character> input=new Stack<>();

        for(Character ch: s.toCharArray())
        {
            if(symbolMap.containsKey(ch) && !input.isEmpty())
            {
               Character popped=input.pop();

               if( popped != symbolMap.get(ch))
               {
                 return false;
               }
            }
            else
            {
                input.push(ch);
            }



        }


        return input.isEmpty();

        // Push --> Open
        // Pop Open --> When we see closed
        // if stack is empty, return true
        // if we find closed and stack is empty, break and return false
    }
}
