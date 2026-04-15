/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {
 *     }
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.right == null) {
                return root.left;
            }

            if (root.left == null) {
                return root.right;
            }

            TreeNode curr = root.right;

            while (curr.left != null) {
                curr = curr.left;
            }

            curr.left = root.left;
            TreeNode result = root.right;
            root = null;

            return result;

        }

        return root;
    }

}