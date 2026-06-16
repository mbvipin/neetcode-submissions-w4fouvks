/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
     
     if( node == null)
     {
        return null;
     }

     Map<Node,Node> oldToNew= new HashMap<>();

     Queue<Node> toProcess= new LinkedList<>();
     toProcess.offer(node);

     oldToNew.put(node, new Node(node.val));

     while( !toProcess.isEmpty())
     {
        Node curr=toProcess.poll();

        for( Node nei: curr.neighbors)
        {
            if(!oldToNew.containsKey(nei))
            {
                oldToNew.put(nei, new Node(nei.val));
                toProcess.offer(nei);
            }
          
          oldToNew.get(curr).neighbors.add(oldToNew.get(nei));

        }


     }


     return oldToNew.get(node);
        
    }
}