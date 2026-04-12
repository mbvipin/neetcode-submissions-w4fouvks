class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

     for( int row=0; row < matrix.length; row++)
     {
        int left=0;
        int right=matrix[row].length-1;

        while( left <= right)
        {
            int mid= (left+right)/2;

            if(target > matrix[row][mid])
            {
                left=mid+1;
            }

            else if ( target < matrix[row][mid])
            {
                right=mid-1;
            }

            else
            {
                return true;
            }


        }
   
  
     }

     return false;
    
        
    }
}
