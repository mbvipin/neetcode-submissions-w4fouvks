class Solution {

    List<List<Integer>> res= new ArrayList<>();
    List<Integer> combination= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {

       dfs(nums,0,target,combination);

       return res;
        
    }

    private void dfs(int [] nums, int start,int target,
    List<Integer> combination)
    {
        if( target == 0)
        {
            List<Integer> newCombination= new ArrayList<>(combination);
            res.add(newCombination);
            return;
        }

        if( target < 0)
        {
            return;
        }
    
        for( int i= start; i < nums.length; i++)
        {
            combination.add(nums[i]);
            dfs(nums,i,target-nums[i],combination);
            combination.remove(combination.size() - 1);
        }


    }


}