class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int current= 2;
        int previous =1;

       for(int i= n-2 ; i > 0 ; i--)
       {
           int temp=current;
           current= current+previous;
           previous=temp;
       }
    
        return current;
    }
}


