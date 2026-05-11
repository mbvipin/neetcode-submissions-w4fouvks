class Solution {
    public int lastStoneWeight(int[] stones) {

        if( stones == null || stones.length == 0)
        {
            return 0;
        }

        List<Integer> stoneList = new ArrayList<> ();

        for(int stone: stones)
        {
            stoneList.add(stone);
        }

        while(stoneList.size()> 1)
        {
            Collections.sort(stoneList);

            int highest=stoneList.remove(stoneList.size()-1);
            int secondHighest= stoneList.remove(stoneList.size()-1);

            int difference= highest- secondHighest;

            if( difference != 0)
            {
            stoneList.add(difference);
            }
        }

        return stoneList.isEmpty()? 0: stoneList.get(0);
        
    }
}
