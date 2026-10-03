class Solution {
    public int longestConsecutive(int[] nums) {

        Map<Integer,Integer> numMap= new HashMap<>();
        int longest=0;

        for(int num: nums)
        {

            if(numMap.containsKey(num))
            {
                continue;
            }

            int left= numMap.getOrDefault(num-1,0);
            int right= numMap.getOrDefault(num+1,0);

            int newLength= left+right+1;

            numMap.put(num,newLength);

            numMap.put(num-left, newLength);
            numMap.put(num+right,newLength);

            longest=Math.max(longest,newLength);

        }

        return longest;
        
    }
}
