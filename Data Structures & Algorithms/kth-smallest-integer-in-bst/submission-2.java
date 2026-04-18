class Solution {

    int count=0;
    int result=-1;
    

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> input= new ArrayList<>();

        collectElements(root,input);

        Collections.sort(input);

        return input.get(k-1);

     
    }

     private void collectElements(TreeNode root,List<Integer> input)
     {
        if(root == null)
        {
            return;
        }

        input.add(root.val);

        collectElements(root.left,input);
        collectElements(root.right,input);

     }
}