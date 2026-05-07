class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        int n= nums.length;

        List<List<Integer>> res= new ArrayList <> ();

        for( int i =0; i < ( 1 << n); i++)
        {
            List<Integer> subset = new ArrayList<>();

            for( int j=0; j< nums.length; j++)
            {
                int toAnd= (1 << j);

                if( (i & toAnd) != 0)
                {
                    subset.add(nums[j]);
                }

            }


            res.add(subset);
        }

        return res;

    }
}
