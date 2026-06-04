class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

       int orig= image[sr][sc];

       if( orig == color)
       {
         return image;
       }

        int rowLength = image.length;
        int colLength = image[0].length;
    
        dfs(image,sr,sc,rowLength,colLength,orig,color);

        return image;
        
    }

    private void dfs( int [][] image,int sr,int sc,int rowLength,
           int colLength,int orig,int color)
    {
        if( sr >= rowLength || sr <0 || sc >= colLength || sc < 0)
        {
            return;
        }

        if( image[sr][sc] != orig)
        {
            return;
        }

        image[sr][sc] = color;

        dfs(image,sr+1,sc,rowLength,colLength,orig,color);
        dfs(image,sr-1,sc,rowLength,colLength,orig,color);
        dfs(image,sr,sc+1,rowLength,colLength,orig,color);
        dfs(image,sr,sc-1,rowLength,colLength,orig,color);

      



    }
}