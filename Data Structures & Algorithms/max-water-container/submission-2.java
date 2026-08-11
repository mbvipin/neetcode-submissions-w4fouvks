class Solution {
    public int maxArea(int[] heights) {
        
        int left=0;
        int right= heights.length-1;

         int maxArea=0;

        while( left < right)
        {
            int area= (right- left) * Math.min( heights[left],heights[right]);

            
            maxArea= Math.max(area,maxArea);


            if( heights[left] < heights[right])
            {
                left = left +1;
            }
            else if( heights[right] < heights[left])
            {
                right= right - 1;
            }
            else
            {
                right= right -1;
            }



        }

        return maxArea;
        
    }
}
