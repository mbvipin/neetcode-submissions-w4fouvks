class Solution {
    public int[] twoSum(int[] nums, int target) {

        int [] res= new int [2];

        Map<Integer,Integer> targetMap= new HashMap<>();

        for(int i= 0; i< nums.length; i++)
        {
            targetMap.put( target- nums[i],i);
        }

        for(int j=0 ; j< nums.length; j++)
        {
            if(targetMap.containsKey(nums[j]))
            {
               int k= targetMap.get(nums[j]);

               if( j != k)
               {
                   res[0]=j;
                   res[1]=k;
                   return res;
               }


            }

        }

        return res;
        
    }
}
