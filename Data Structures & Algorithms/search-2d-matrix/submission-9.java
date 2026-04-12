class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int ROWS= matrix.length;
        int COLS= matrix[0].length;

        int low=0;
        int high= (ROWS * COLS)-1;

        while( low <= high)
        {
            int mid= (low+high)/2;

            int row= mid/COLS;
            int col= mid % COLS;

            if( target > matrix[row][col])
            {
                low= mid+1;
            }

            else if( target < matrix[row][col])
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
