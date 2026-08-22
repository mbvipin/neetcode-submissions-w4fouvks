class NumMatrix {

    private int [][] prefixSum;

    public NumMatrix(int[][] matrix) {

        int ROWS= matrix.length;
        int COLS= matrix[0].length;

        prefixSum= new int [ROWS+1][COLS+1];

        for( int row=0; row < ROWS; row++)
        {
            int prefix=0;

             for(int col=0; col < COLS; col++)
             {
                prefix += matrix[row][col];
                int above= prefixSum[row][col+1];

                prefixSum[row +1][col+1]= prefix + above;


             }


        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {


        row1++; col1++; row2++; col2++;

        int bottomRight= prefixSum[row2][col2];
        int topRight= prefixSum[ row1-1][col2];
        int bottomLeft= prefixSum[row2][col1-1];
        int topLeft= prefixSum[row1-1][col1-1];

        return bottomRight - topRight -bottomLeft+ topLeft;


        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */