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

        this.root = null;
        
    }

    public void insert(int key, int val) {

        TreeNode newNode= new TreeNode(key, val);

        if( root == null)
        {
           root = newNode;
           return;
        }

        TreeNode current= root;

        while( true)
        {
            if( key > current.key)
            {
                if( current.right == null)
                {
                    current.right = newNode;
                    return;
                }

             current = current.right;
            }

            else if( key < current.key)
            {
                if( current.left == null)
                {
                    current.left = newNode;
                    return;
                }
              
                current = current.left;
            }

            else
            {
                current.val = val;
                return;
            }

        }

    }

    public int get(int key) {

        TreeNode current = root;

        while( current != null)
        {
            if( key > current.key)
            {
                current = current.right;
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

        TreeNode minNode= findMin(this.root);

        return minNode != null? minNode.val: -1;

    }

    private TreeNode findMin(TreeNode root)
    {
        TreeNode current = root;

        while( current != null && current.left != null)
        {
            current= current.left;
        }
        
        return current;

    }

    public int getMax() {

        TreeNode maxNode= findMaxNode();

        return maxNode != null? maxNode.val: -1 ;

    }

    private TreeNode findMaxNode()
    {
        TreeNode current = root;

        while( current != null && current.right != null)
        {
            current = current.right;
        }

      return current;

    }

    public void remove(int key) {

        this.root= removeHelper(root, key);
       
    }

    private TreeNode removeHelper(TreeNode root,int key)
    {
        if( root == null)
        {
            return null;
        }

        if( key > root.key)
        {
           root.right= removeHelper(root.right,key);
        }

        else if ( key < root.key)
        {
           root.left= removeHelper(root.left, key);
        }

        else
        {
            if( root.left == null)
            {
                root= root.right;
            }

            else if ( root.right == null)
            {
                root = root.left;
            }

            else
            {
                 TreeNode minNode = findMin(root.right);

                 root.key = minNode.key;
                 root.val = minNode.val;

                 root.right= removeHelper(root.right,minNode.key);
            }


        }


       return root;
    }

    public List<Integer> getInorderKeys() {

    List<Integer> res = new ArrayList<>();

    inOrderTraversal(this.root,res);

    return res;

    }

    private void  inOrderTraversal( TreeNode root, List<Integer> res)
    {
        if( root == null)
        {
            return;
        }

        inOrderTraversal(root.left, res);
        res.add(root.key);
        inOrderTraversal(root.right,res);

    }
}
