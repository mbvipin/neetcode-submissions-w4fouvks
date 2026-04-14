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

        if(root == null)
        {
            return null;
        }

        TreeNode curr=root;
        TreeNode parent=null;

        while(curr!=null && curr.val != key)
        {
            parent=curr;
            if( key > curr.val)
            {
                curr=curr.right;
            }

            else if( key < curr.val)
            {
                curr= curr.left;
            }

        }

        // key not found
        if( curr == null)
        {
            return root;
        }

        // key found, both children are empty
        if( curr.left == null && curr.right == null)
        {
            // It is root, delete it and tree becomes empty
            if(parent== null) return null;

           // deleting curr and linking parent to null on left side
            else if (parent.left == curr)
            {
                parent.left=null;
            }

            // deleting curr and linking parent to null on right side
            else if( parent.right== curr)
            {
                parent.right=null;
            }
           
           return root;
  
        }

        // if the node has only right child
        if(curr.left == null)
        {
            if( curr== root)
            {
                root= curr.right;
            }

            else if( parent.right== curr)
            {
                parent.right= curr.right;
            }

            else if( parent. left == curr)
            {
                parent.left= curr.right;
            }
           
           return root;

        }

        //if node has only left child
        if( curr.right == null)
        {
            if( curr == root)
            {
                root= curr.left;
            }

            else if( parent.right== curr)
            {
                parent.right= curr.left;
            }

            else if (parent.left == curr)
            {
                parent.left= curr.left;
            }

            return root;
        }

        // if node has both children
        if( curr.left!= null && curr.right!=null)
        {
            TreeNode succParent= curr;
            TreeNode succ= curr.right;

            while( succ.left!=null)
            {
                succParent=succ;
                succ=succ.left;

            }

            curr.val= succ.val;
            if(succParent == curr)
            {
               curr.right=succ.right;
            }
            else
            {
                succParent.left= succ.right;
            }


        }

        return root;
    }

}