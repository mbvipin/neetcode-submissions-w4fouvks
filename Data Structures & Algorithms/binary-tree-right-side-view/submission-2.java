class Solution {


    public List<Integer> rightSideView(TreeNode root) {


      List<Integer> res= new ArrayList<>();
      Queue<TreeNode> input= new LinkedList<>();

        input.offer(root);

        while(!input.isEmpty())
        {

            int size= input.size();
            TreeNode rightMost= null;

            for( int i=0; i< size; i++)
            {
                TreeNode curr= input.poll();

                if( curr != null)
                {
                    rightMost =curr;

                    input.offer(curr.left);
                    input.offer(curr.right);
                }
            }

            if( rightMost != null)
            {
                res.add(rightMost.val);
            }


        }

       return res;
    }

   
}