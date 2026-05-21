class Solution {
    public boolean hasDuplicate(int[] nums) {

        if( nums == null || nums.length == 0)
        {
            return false;
        }

        Map<Integer,Integer> input = new HashMap<>();

        for(int num: nums)
        {
            if(!input.containsKey(num)){
               input.put(num,1);
            }

            else 
            {
                return true;
            }


        }

        return false;


        
    }
}