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

     int index=0;

     Map<Integer,Integer> indices= new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for( int i= 0; i< inorder.length; i++)
        {
            indices.put(inorder[i],i);
        }

        return buildTree(preorder, 0, inorder.length-1);

      
      }

      public TreeNode buildTree(int [] preorder, int l, int r)
      {
        if( l > r)
        {
            return null;
        }

        int root_val= preorder[index];
        index=index+1;

         int mid= indices.get(root_val);

         TreeNode root=new TreeNode(root_val);

         root.left= buildTree(preorder, l, mid-1);
         root.right= buildTree(preorder, mid+1,r);

         return root;


      }
       
        
    }

