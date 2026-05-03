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

        Stack<TreeNode> nodeStack = new Stack<> ();
        Stack<Integer> sumStack = new Stack <> ();

        nodeStack.push(root);
        sumStack.push( targetSum - root.val);

        while( !nodeStack.isEmpty())
        {
            TreeNode current = nodeStack.pop();
            Integer currSum =sumStack.pop();

            if( current.left == null && current.right == null
            && currSum == 0)
            {
                return true;
            }

            if( current.left != null)
            {
                nodeStack.push(current.left);
                sumStack.push(currSum - current.left.val);
            }

            if( current.right != null)
            {
                nodeStack.push(current.right);
                sumStack.push(currSum - current.right.val);
            }


        }

        return false;
        
    }
}