class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int top=0;
        int bot= matrix.length-1;

        int rightMost= matrix[0].length-1;
        int selectedRow= -1;

        while( top <= bot)
        {
            int mid= (top+bot)/2;

            if(target > matrix[mid][rightMost])
            {
                top= mid+1;
            }

            else if (target < matrix[mid][0])
            {
               bot=mid-1;
            }

            else
            {
                selectedRow=mid;
                break;
            }


        }

        if( top > bot)
        {
            return false;
        }

         int low=0;
         int high= rightMost;

        while( low <= high)
        {
            int mid= (low+high)/2;

            if(target > matrix[selectedRow][mid])
            {
                low=mid+1;

            }

            else if( target < matrix[selectedRow][mid])
            {
                high= mid-1;
            }

            else
            {
                return true;
            }
        }

       return false;
    
    }
}
