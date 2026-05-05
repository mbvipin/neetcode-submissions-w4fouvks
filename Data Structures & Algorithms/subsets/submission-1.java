class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res= new ArrayList <> ();
        List<Integer> subset = new ArrayList <>();

        dfs(nums,0,subset,res);

        return res;
        
    }

    private  void dfs(int [] nums,int start, List<Integer> subset,
        List<List<Integer>> res)
        {
            if( start >= nums.length)
            {
                res.add(new ArrayList<>(subset));
                return;
            }

             System.out.println(start);

            subset.add(nums[start]);
            dfs(nums,start+1,subset,res);

            subset.remove(subset.size()-1);
            dfs(nums, start+1, subset,res);


        }
}
