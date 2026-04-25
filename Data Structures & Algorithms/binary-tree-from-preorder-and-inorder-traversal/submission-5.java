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

    int pIndex=0;
    int iIndex=0;

    public TreeNode buildTree(int [] preorder, int[] inorder)
    {

        return dfs(preorder,inorder, Integer.MAX_VALUE);

    }

    private TreeNode dfs( int [] preorder, int [] inorder, int limit)
    {
        if(pIndex >= preorder.length)
        {
            return null;
        }

        if(inorder[iIndex]== limit)
        {
            iIndex=iIndex+1;
            return null;
        }

         int root_val= preorder[pIndex];
         pIndex=pIndex+1;

         TreeNode root=new TreeNode(root_val);

         root.left= dfs(preorder, inorder,root.val);
         root.right=dfs(preorder, inorder,limit);

         return root;


    }


       
        
    }

