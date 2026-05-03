/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if( root == null)
        {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList <> ();

        nodeQueue.offer(root);
        sumQueue.offer(targetSum - root.val);

        while( !nodeQueue.isEmpty())
        {
            TreeNode current = nodeQueue.poll();
            Integer currSum = sumQueue.poll();

            if( currSum == 0 && current.left == null && current.right == null)
            {
                return true;
            }

            if( current.left != null)
            {
                nodeQueue.offer(current.left);
                sumQueue.offer(currSum - current.left.val);
            }

             if( current.right != null)
            {
                nodeQueue.offer(current.right);
                sumQueue.offer(currSum - current.right.val);
            }

        }
        return false;
    }
}