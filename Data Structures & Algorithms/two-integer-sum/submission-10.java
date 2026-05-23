class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> prevMap= new HashMap<>();

        for(int i=0; i< nums.length; i++)
        {
            int difference= target-nums[i];

            if(prevMap.containsKey(difference))
            {
                int [] res= new int[2];

                res[0]= prevMap.get(difference);
                res[1]=i;
                return res;
            }

            prevMap.put(nums[i],i);


        }

        return new int[0];
        
    }
}
