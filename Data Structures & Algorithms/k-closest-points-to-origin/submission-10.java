class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int L=0;
        int R= points.length-1;
        int pivot= points.length;

        while(pivot != k)
        {
            pivot=findPivot(points,L,R);

            if(k > pivot)
            {
                L= pivot+1;
            }

            else
            {
                R= pivot -1;
            }


        }

        int [][] res= new int [k][2];

        System.arraycopy(points,0,res,0,k);

        return res;  

    }

    private int findPivot(int [][] points,int l, int r)
    {
        int pivotIndex= r;
        int pivotDistance= findDistance(points[pivotIndex]);

        int i= l;

        for( int j= l ; j < r ; j++)
        {
            if( findDistance(points[j])< pivotDistance)
            {
              swap(i,j,points);
               i= i+1;
            }


        }

        swap(i,pivotIndex,points);

        return i;


    }

    private int findDistance(int [] point)
    {
        return point[0]* point[0]+ point[1]* point[1];
    }

    private void swap(int from, int to, int [][] points)
    {
        int [] temp = points[from];
        points[from]= points[to];
        points[to]= temp;


    }
}
