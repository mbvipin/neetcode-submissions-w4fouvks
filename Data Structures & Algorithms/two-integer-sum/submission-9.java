class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> input= new HashMap<>();

        for( int i= 0; i< nums.length ; i++)
        {
            input.put(nums[i],i);
        }

        for( int j=0; j< nums.length; j++)
        {
            int complement= target- nums[j];

            if(input.containsKey(complement))
            {
                int secondIndex=input.get(complement);

                if (secondIndex != j) {
                    int [] res= new int [2];
                    res[0]= j;
                    res[1]= secondIndex;
                    return res;
                }
            }



        }

        return new int [0];
        
    }
}