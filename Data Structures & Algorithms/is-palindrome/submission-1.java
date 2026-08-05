class Solution {
    public boolean isPalindrome(String s) {

        int left=0;
        int right= s.length()-1;

        while ( left < right)
        {
            while( left < right && !alphaNum(s.charAt(left)))
            {
                left++;
            }

            while( right > left &&   !alphaNum(s.charAt(right)))
            {
                right --;
            }

            char leftChar= Character.toLowerCase(s.charAt(left));
            char rightChar= Character.toLowerCase(s.charAt(right));

            if(leftChar != rightChar)
            {
                return false;
            }

            left++;
            right--;


        }

        return true;
        
    }

    public boolean alphaNum(char c)
    {
        return ( c >= 'A' && c <= 'Z' ||
                 c >= 'a' && c <= 'z' ||
                 c >= '0' && c <= '9');

    }
}
