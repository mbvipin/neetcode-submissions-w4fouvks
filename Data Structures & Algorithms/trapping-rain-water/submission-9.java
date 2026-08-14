class Solution {
    public int trap(int[] height) {

        Stack<Integer> trap= new Stack <>();
        int res=0;

        for(int i=0; i < height.length; i++)
        {
            while( !trap.isEmpty() && height[i] > height[trap.peek()])
            {
                int bottom= height[trap.pop()];

                if( !trap.isEmpty())
                {
                    int left= height[trap.peek()];
                    int right= height[i];

                    int h= Math.min(left,right) - bottom;
                    int w= i - trap.peek() -1;

                    res += h * w;
                }

             


            }

               trap.push(i);



        }

       return res;
        
    }
}
