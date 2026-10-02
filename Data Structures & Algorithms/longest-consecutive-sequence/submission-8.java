class Solution {
    public int longestConsecutive(int[] nums) {

        if( nums == null || nums.length==0 )
        {
            return 0;
        }

        Arrays.sort(nums);

        int curr=nums[0];
        int next= curr+1;

        int length=1;
        int longest=1;

         for(int num: nums)
         {
            if( num == curr)
            {
                continue;
            }

            else if( num == next)
            {
                length++;
                longest= Math.max(longest,length);
                curr= next;
                next= curr+1;

            }

            else
            {
                length=1;
                curr= num;
                next= curr+1;
                continue;
            }


         }

         return longest;
        
    }
}
