class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Queue<int[]> heap = new PriorityQueue<>(
            Comparator.comparing(element -> element[0])
        );

        for(int [] point : points)
        {
            int x= point[0];
            int y= point[1];
            int distance= x *x + y *y;

            int [] newPoint= new int [] {distance,x, y};

            heap.offer(newPoint);
        }
        
        int [] [] res= new int [k] [2];

        for( int i= 0; i< k ; i++)
        {
            int [] polled= heap.poll();

            res[i]= new int [] {polled[1],polled[2]};

        }

      return res;
    }
}
