class Solution {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for( int num: nums)
        {
            heap.offer(num);
        }

        for(int i= 1; i< k; i++)
        {
            System.out.println(heap.poll());
      
        }

        return heap.peek();
        
    }
}
