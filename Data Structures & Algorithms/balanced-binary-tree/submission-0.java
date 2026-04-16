/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {\ this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {

        boolean isBalanced=true;

        if(root == null)
        {
            return true;
        }

        if( root.left== null && root.right == null)
        {
            return true;
        }

        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);

        if(Math.abs(leftHeight-rightHeight)> 1)
        {
            isBalanced= false;
        }


        return isBalanced && isBalanced(root.left) && isBalanced(root.right);
    }

    public int findHeight(TreeNode root)
    {
        if( root == null)
        {
            return 0;
        }

        if( root.left== null && root.right== null)
        {
            return 1;
        }

        int leftHeight=findHeight(root.left);
        int rightHeight=findHeight(root.right);

        return Math.max(1+leftHeight,1+rightHeight);


    }
}