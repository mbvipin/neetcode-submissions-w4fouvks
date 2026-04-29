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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode head= new TreeNode(0);
        TreeNode curr= head;

        int i=0;
        int j=0;

        int n= preorder.length;


        while( i< n && j < n)
        {
           curr.right= new TreeNode(preorder[i],null, curr.right);
           curr=curr.right;
           i=i+1;

           while( i < n && curr.val != inorder[j])
           {

            curr.left= new TreeNode(preorder[i],null,curr);
            curr= curr.left;
            i= i+1;
           }

           j= j+1;

           while( curr.right!=null && j <n && curr.right.val==inorder[j])
           {

            TreeNode temp= curr.right;
            curr.right=null;

            curr= temp;

            j= j+1;
           }
        }

            return head.right;
        }
      
    
}