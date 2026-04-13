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
    public TreeNode deleteNode(TreeNode root, int key) {

        if( root == null)
        {
            return null;
        }

        TreeNode curr=root;
        TreeNode parent= null;

        while(curr!=null && curr.val != key)
        {
            parent=curr;

            if( key > curr.val)
            {
               curr=curr.right;
            }
            else
            {
              curr=curr.left;
            }
        }

        if( curr == null) return root;

        if( curr.left == null && curr.right == null)
        {
            if(curr == root ) {
                root = null;
            }
            
            else if(parent.left == curr)
            {
                parent.left=null;
            }

            else if( parent.right== curr)
            {
                parent.right=null;
            }
           return root;
        }

        if(curr.left == null)
        {
            TreeNode temp= curr.right;

            if( curr== root)
            {
                root= temp;
            }
            else if( parent.left== curr)
            {
                parent.left=temp;
            }

            else if( parent.right == curr)
            {
                parent.right= temp;
            }

            return root;
           
        }

        else if( curr.right == null)
        {
           TreeNode temp= curr.left;

           if( curr == root) return temp;

           else if( parent.left== curr)
           {
            parent.left= temp;
           }

           else if( parent.right == curr)
           {
            parent.right= temp;
           }

           return root;
        }

        TreeNode succParent=curr;
        TreeNode succ= curr.right;

        while( succ.left != null)
        {
          
            succParent=succ;
            succ=succ.left;
        }

        curr.val=succ.val;

        if(succParent == curr)
        {
            succParent.right=succ.right;
        }

        else
        {
           succParent.left= succ.right;
        }

       return root;
    }

}