class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

      int row=0;
      int col= matrix[0].length-1;

      while( row >= 0 && row <= matrix.length-1 &&
            col >=0 && col <= matrix[0].length-1)
       {

           if(matrix[row][col] > target)
           {
                col= col-1;
           }

           else if(matrix[row][col] < target)
           {
                row= row+1;
           }

           else
           {
            return true;
           }

       }

  
    return false;
    
    }
}
