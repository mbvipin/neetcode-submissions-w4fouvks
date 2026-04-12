class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row= 0;
        int col=matrix[0].length-1;


        while( row >=0 && row < matrix.length && col >=0 && 
        col <matrix[0].length)
        {

        if( target > matrix[row][col])
        {
            row= row+1;
        }

        else if( target <matrix[row][col])
        {
            col= col-1;
        }

        else
        {
            return true;
        }
        }

        return false;

   
    }
}
