class Node
{
    public int key;
    public int value;
    public Node next;
    public Node prev;

    public Node(int key, int value)
    {
        this.key=key;
        this.value=value;
    }


}

class LRUCache {

     private int capacity;
     private Map<Integer,Node> cache;
     private Node right;
     private Node left;

    public LRUCache(int capacity) {

        this.capacity= capacity;
        cache= new HashMap<>();
        this.right= new Node(0,0);
        this.left= new Node(0,0);

        this.left.next= this.right;
        this.right.prev= this.left;
        
    }

    private void remove(Node node)
    {
        Node prev= node.prev;
        Node next= node.next;

        prev.next= next;
        next.prev= prev;
    }

    private void insert(Node node)
    {
        Node firstNode= this.left.next;

        this.left.next= node ;
        node.prev= this.left;

        node.next= firstNode;
        firstNode.prev= node;

    }
    
    public int get(int key) {
        
        if( cache.containsKey(key))
        {
            Node node= cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

        return -1;

    }
    
    public void put(int key, int value) {

        if( cache.containsKey(key))
        {
           Node node= cache.get(key);
           node.value= value;
           remove(node);
           insert(node);
           return;
        }

        if( cache.size() == capacity)
        {
            Node lru = this.right.prev;
            cache.remove(lru.key);
            remove(lru);
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
        
    }
}