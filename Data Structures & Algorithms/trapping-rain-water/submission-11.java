class Solution {
    public int trap(int[] height) {

        int left=0;
        int right= height.length-1;

        int leftMax= height[left];
        int rightMax= height[right];

        int res=0;

        while( left < right)
        {
            if( leftMax < rightMax)
            {
            left++;
            leftMax= Math.max(height[left],leftMax);
             res += leftMax- height[left];
            
            }

            else
            {
            right--;
            rightMax= Math.max( height[right],rightMax);
            res += rightMax -height[right];
          
            }

        }

        return res;
        
    }
}
