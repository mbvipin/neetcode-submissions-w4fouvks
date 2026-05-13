class Solution {
    public int lastStoneWeight(int[] stones) {

        int maxStone = 0;

        for(int stone: stones)
        {
            maxStone= Math.max(stone,maxStone);
        }

        int [] stoneArray= new int [maxStone+1];
        for(int stone: stones)
        {
            stoneArray[stone]++;
        }

        int first=maxStone;
        int second= maxStone;

        while( first > 0)
        {
            if( stoneArray[first] % 2 == 0)
            {
                first = first -1;
                continue;
            }

            int j = Math.min(first-1, second);

            while( j > 0 && stoneArray[j] == 0)
            {
                j= j-1;
            }

            if( j== 0)
            {
                return first;
            }

            second=j;
            stoneArray[first]--;
            stoneArray[second]--;
            stoneArray[first-second]++;

            first= Math.max(first-second,second);
        }

        return first;
        
    }
}
