class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> heap = new PriorityQueue<>(
            (a,b)->
            {
                return b.compareTo(a);

            }
        );

        for(int stone: stones)
        {
            heap.offer(stone);

        }

        while( heap.size() > 1)
        {
           int highest= heap.poll();
           int secondHighest= heap.poll();

          int difference=highest- secondHighest;

          if( difference != 0)
          {
            heap.offer(difference);
          }


        }

        return  heap.isEmpty()? 0: heap.peek();
        
    }
}
