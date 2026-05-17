class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int L =0;
        int R= points.length-1;
        int pivot= points.length;

        while( pivot != k)
        {
             pivot= partition(points,L,R);

            if( k > pivot)
            {
                L= pivot +1;
            }

            else if( k < pivot)
            {
                R = pivot -1;
            }



        }

        

        return Arrays.copyOfRange(points,0,k);

    }

        private int partition(int [][] points,int l, int r)
        {
            int pivot= r;
            int pivotDistance=getDistanceFromOrigin(points[pivot]);

            int i =l;

            for( int j= l; j < r ; j++)
            {
                int currentDistance=getDistanceFromOrigin(points[j]);
                if(currentDistance < pivotDistance)
                {
                    swap(points,j,i);
                    i++;
                }



            }

            swap(points,i,pivot);
           
           return i;
        }

        private int getDistanceFromOrigin(int [] point)
        {
            return point[0]*point[0]+ point[1]* point[1];
        }

        private void swap(int [] [] points,int from, int to)
        {
            int [] temp= points[from];
            points[from]= points[to];
            points[to]=temp;


        }
        
    }

