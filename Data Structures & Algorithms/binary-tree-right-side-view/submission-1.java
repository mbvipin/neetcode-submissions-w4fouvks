class Solution {

      List<Integer> res= new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

       dfs(root,0);

       return res;
    }

    private void dfs(TreeNode root, int depth)
    {
        if( root == null)
        {
            return ;
        }

        if( res.size() == depth)
        {
            res.add(root.val);
        }

        dfs(root.right,depth+1);
        dfs(root.left, depth+1);


    }
}