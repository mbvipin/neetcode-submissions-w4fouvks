class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int top=0;
        int bottom=matrix.length-1;

        int rightMost=matrix[0].length-1;

        while(top <= bottom)
        {

            int mid= top+(bottom-top)/2;

            if(target > matrix[mid][rightMost])
            {
                top=mid+1;

            }

            else if( target < matrix[mid][0])
            {
                bottom=mid-1;
            }

            else
            {
                break;
            }


        }

        if( top > bottom)
        {
            return false;
        }

        int chosen= top+ (bottom-top)/2;

        int low= 0;
        int high= rightMost;

        while(low <= high)
        {
            int mid= low+(high-low)/2;

            if(target > matrix[chosen][mid])
            {
                low= mid+1;
            }

            else if (target < matrix[chosen][mid])
            {
                high=mid-1;
            }

            else
            {
                return true;
            }


        }

        return false;



    }
}
