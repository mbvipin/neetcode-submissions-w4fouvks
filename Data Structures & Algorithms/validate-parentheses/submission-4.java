class Solution {
    public boolean isValid(String s) {

        

        Map<Character,Character> symbols=new HashMap<>();
        Set<Character> open=new HashSet<>();
        Set<Character> closed=new HashSet<>();

        open.add('(');
        open.add('{');
        open.add('[');

        closed.add(')');
        closed.add('}');
        closed.add(']');



        symbols.put('(',')');
        symbols.put('{','}');
        symbols.put('[',']');

        if(s.length() < 2)
        {
            return false;
        }

        Stack<Character> stack=new Stack<>();

        for( Character c: s.toCharArray())
        {
            if(open.contains(c))
            {
                stack.push(c);
            }

            if( closed.contains(c))
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                Character popped=stack.pop();
                if(symbols.get(popped)!= c )
                {
                    return false;
                }

            }

            else
            {
                continue;
            }
            


        }


        return stack.isEmpty();
    }
}
