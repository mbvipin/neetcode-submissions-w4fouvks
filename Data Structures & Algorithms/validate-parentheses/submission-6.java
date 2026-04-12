class Solution {
    public boolean isValid(String s) {

        Map<Character,Character> symbolMap=new HashMap<>();

        symbolMap.put(')','(');
        symbolMap.put('}','{');
        symbolMap.put(']','[');



        Stack<Character> stack=new Stack<>();

        for(Character c: s.toCharArray())
        {
            if(symbolMap.containsKey(c) )
            {
                if(!stack.isEmpty())
                {
                    Character popped= stack.pop();

                    if( popped != symbolMap.get(c))
                    {
                        return false;
                    }
                }

                else
                {
                    return false;
                }
            

            }

            else
            {
                stack.push(c);
            }




        }

        return stack.isEmpty();

        
    }
}
