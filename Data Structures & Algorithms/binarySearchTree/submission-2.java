
class TreeNode
{
    int key;
    int val;

    TreeNode left;
    TreeNode right;

    public TreeNode(int key, int val)
    {
        this.key= key;
        this.val= val;
    }


}


class TreeMap {

    TreeNode root;

    public TreeMap() {

        root = null;
        
    }

    public void insert(int key, int val) {

        TreeNode newNode= new TreeNode(key, val);

        if( root == null)
        {
            root = newNode;

            return;
        }

         TreeNode curr= root;

         while(true)
         {

         if( key < curr.key)
         {
             if( curr.left == null)
             {
                curr.left= newNode;
                return;
             }
             curr= curr.left;
         }
         else if( key > curr.key)
         {
            if( curr.right == null)
            {
            curr.right=newNode;
            return;
            }
            curr= curr.right;
         }
         else
         {
            curr.val = val;
            return;
         }

         }

        

    }

    public int get(int key) {

        TreeNode current= root;

        while(current != null)
        {
            if( key > current.key)
            {
                current= current.right;
            }

            else if ( key < current.key)
            {
                current= current.left;
            }
            else
            {
                return current.val;
            }



        }

        return -1;

    }

    public int getMin() {

        TreeNode minNode= findMin(root);

        return minNode != null? minNode.val: -1;

    }

    private TreeNode findMin(TreeNode root)
    {
        TreeNode current= root;

        while( current !=null && current.left != null)
        {
            current= current.left;
        }

        return current;


    }

    public int getMax() {

        TreeNode maxNode= findMax(root);

        return maxNode !=null? maxNode.val: -1;

    }

    private TreeNode findMax(TreeNode root)
    {
        TreeNode current= root;

        while( current != null && current.right != null)
        {
            current = current.right;
        }
        
        return current;

    }

    public void remove(int key) {

        root= removeHelper(root, key);
       
    }

    private TreeNode removeHelper(TreeNode root, int key)
    {
        if( root == null)
        {
            return null;
        }

        TreeNode current = root;

        if( key > current.key)
        {
        
          current.right= removeHelper(current.right,key);
          
        }

        else if ( key < current.key)
        {
            current.left= removeHelper(current.left,key);

        }

        else
        {
            if( current.left == null)
            {
                current= current.right;
            }

            else if( current.right == null)
            {
                current= current.left;
            }

            else
            {
                TreeNode minNode= findMin(current.right);

                current.key= minNode.key;
                current.val= minNode.val;
            
               current.right=removeHelper( current.right,minNode.key);
            }
        }

        return current;

    }

    public List<Integer> getInorderKeys() {

        List<Integer> result= new ArrayList<>();
        inOrderTraversal(root,result);
        return result;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> res)
    {
        if( root == null)
        {
            return;
        }

        inOrderTraversal(root.left,res);
        res.add(root.key);
        inOrderTraversal(root.right,res);

    }
}
