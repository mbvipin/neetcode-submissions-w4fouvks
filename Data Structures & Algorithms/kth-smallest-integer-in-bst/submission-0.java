class Solution {
    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return result;
        }

        kthSmallest(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return result;
        }

        kthSmallest(root.right, k);

        return result;
    }
}