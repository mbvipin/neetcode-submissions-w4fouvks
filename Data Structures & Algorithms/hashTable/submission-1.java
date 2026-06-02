class Node
{
    public int key;
    public int value;

    public Node next;

    public Node(int key, int value)
    {
        this.key= key;
        this.value= value;
    }


}


class HashTable {

    private int capacity;
    private int size;

    private Node [] table;

    public HashTable(int capacity) {

        this.capacity= capacity;
        this.size = 0;
        table= new Node[capacity];

    }

    private int hashFunction(int key)
    {
        return Math.abs(key) % this.capacity;
    }

    public void insert(int key, int value) {
        int index= this.hashFunction(key);
        Node curr = this.table[index];

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }

        if (curr == null) {
            this.table[index] = new Node(key, value);
        } else {
            curr.next = new Node(key, value);
        }
        
        this.size++;
        if ((double)this.size / capacity >= 0.5) {
            this.resize();
        }
    }

    public int get(int key) {

        int index= this.hashFunction(key);

        Node node = this.table[index];

        Node curr= node;

        while( curr != null)
        {
            if( curr.key == key)
            {
                return curr.value;
            }
            curr= curr.next;
        }

        return -1;

    }

    public boolean remove(int key) {

        int index = this.hashFunction(key);
        Node curr = this.table[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    this.table[index] = curr.next;
                }
                this.size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public int getSize() {

        return this.size;

    }

    public int getCapacity() {

        return this.capacity;

    }

    public void resize() {
       int oldCapacity = capacity;
       this.capacity = 2 * oldCapacity;
       Node[] oldTable = this.table;
       this.table = new Node[this.capacity];
       this.size = 0;

       for (Node node : oldTable) {
           while (node != null) {
               insert(node.key, node.value);
               node = node.next;
           }
       }
    }
}