class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Queue<int []> heap = new PriorityQueue<>(
         Comparator.comparing(element -> element[0])
        );

        for(int [] point : points){

            int d = point[0]* point[0] + point[1] * point[1];

            int [] newElement= new int [] {d, point[0],point[1]};

            heap.offer(newElement);
        }

        int [] [] res= new int [k][2];

        for(int i=0 ; i< k; i++)
        {
            int [] polled=heap.poll();

            res[i]= new int [] {polled[1],polled[2]};


        }

        return res;

    }
}
