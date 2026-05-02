class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        if( root == null)
        {
            return List.of();
        }

        Queue<TreeNode> input= new LinkedList<>();
        List<Integer> res= new ArrayList<>();

        input.offer(root);

        while(!input.isEmpty())
        {
            int size= input.size();

            for(int i=0; i< size; i++)
            {
                TreeNode curr= input.poll();

       

                if(  curr.left != null)
                {
                    input.offer(curr.left);
                }

                if( curr.right != null )
                {
                    input.offer(curr.right);
                }
                 
                 if( i == size-1)
                 {
                    res.add(curr.val);
                 }


            }



        }
        return res;
    }
}