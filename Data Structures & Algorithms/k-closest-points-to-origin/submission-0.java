class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Queue<Double> heap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        Map<Double, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            int squareX = point[0] * point[0];
            int squareY = point[1] * point[1];

            int sumSquare = squareX + squareY;
            double distance = Math.sqrt(sumSquare);

            heap.offer(distance);
            if (heap.size() > k) {
                heap.poll();
            }

            List<Integer> newPoint = new ArrayList<>();
            newPoint.add(point[0]);
            newPoint.add(point[1]);

            map.computeIfAbsent(distance, x -> new ArrayList<>()).add(newPoint);
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            Double distance = heap.poll();

            List<Integer> point = map.get(distance).remove(0);
            result[i] = new int[]{point.get(0), point.get(1)};
        }

        return result;
    }
}