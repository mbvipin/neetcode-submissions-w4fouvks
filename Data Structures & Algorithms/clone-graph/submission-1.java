class Solution {
    public Node cloneGraph(Node node) {

        if( node == null) return null;

        Map<Node,Node> oldToNew= new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        oldToNew.put(node, new Node(node.val));
        q.add(node);

        while(!q.isEmpty())
        {
            Node curr= q.poll();

            for(Node nei: curr.neighbors)
            {
                if( !oldToNew.containsKey(nei))
                {oldToNew.put(nei, new Node(nei.val));
                    q.add(nei);
                }

                  oldToNew.get(curr).neighbors.add(oldToNew.get(nei));
            }
        }


        return oldToNew.get(node);
        
    }
}