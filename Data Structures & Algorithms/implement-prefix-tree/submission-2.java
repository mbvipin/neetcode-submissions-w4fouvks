class TrieNode
{
    private Map<Character,TrieNode> children=new HashMap<>();
    private boolean endOfWord;


}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {

        root = new TrieNode();
         
    }

    public void insert(String word) {

        TrieNode curr= root;

        for(Character c: word.toCharArray())
        {
            curr.children.putIfAbsent(c, new TrieNode());

            curr= curr.children.get(c);
        }

        curr.endOfWord= true;

    }

    public boolean search(String word) {

        TrieNode curr= root;

        for( Character c: word.toCharArray())
        {
            if(!curr.children.containsKey(c))
            {
                return false;
                
            }
            curr= curr.children.get(c);
        }

        return curr.endOfWord;

    }

    public boolean startsWith(String prefix) {

        TrieNode curr= root;

        for(Character c: prefix.toCharArray())
        {
            if(!curr.children.containsKey(c))
            {
                return false;
            }

            curr= curr.children.get(c);
        }

        return true;

    }
}
