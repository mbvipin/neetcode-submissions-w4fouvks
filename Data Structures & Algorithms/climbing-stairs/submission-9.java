class Solution {
    public int climbStairs(int n) {

        int next=1;
        int prev=1;

        for( int i= n ; i>1 ; i--)
        {
            int tmp=next;
            next=next+prev;
            prev=tmp;

        }

        return next;
    }
       
}
