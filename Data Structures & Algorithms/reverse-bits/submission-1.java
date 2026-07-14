class Solution {
    public int reverseBits(int n) {

        StringBuilder numberString= new StringBuilder();

        for(int i=0; i < 32 ; i++)
        {
            if( ( n & 1 << i) != 0)
            {
                numberString.append('1');
            }

            else
            {
                numberString.append('0');
            }


        }

        String reversedString= numberString.reverse().toString();

        int res =0;
        for( int i=0; i < 32; i++)
        {
            if( reversedString.charAt(i) == '1')
            {

                  res |= 1 << i;
            }


        }

         return res;
        
    }
}
