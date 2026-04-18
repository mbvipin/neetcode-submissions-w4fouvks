class Solution {

    int count=0;
    int result=-1;
    

    public int kthSmallest(TreeNode root, int k) {

        if( root == null)
        {
            return -1;
        }

        kthSmallest(root.left,k);

        count=count+1;

        if( count == k)
        {
            result=root.val;
        }

       kthSmallest(root.right,k);

        return result;
     
    }
}