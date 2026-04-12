/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *		      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {

        int left= 1;
        int right=n;

        while( left <= right)
        {
            int m1=  left+(right-left)/3;
            int m2=  right-(right-left)/3;

            int res1 = guess(m1);
            int res2 = guess(m2);

            if( res1 == 0)
            {
                return m1;

            }

            if( res2 == 0)
            {
                return m2;
            }

            if( res1 == 1 && res2 == -1)
            {
                left= m1+1;
                right=m2-1;
            }

            else if( res1 == -1)
            {
                right= m1-1;
            }

            else if( res2 == 1)
            {
                left= m2+1;
            }
        }
       
        return -1;
    }
    
}