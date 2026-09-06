class PrefixTree {

    private TrieNode root;

    public PrefixTree() {

        this.root= new TrieNode();

         
    }

    public void insert(String word) {

        TrieNode curr =root;

        for( char c: word.toCharArray())
        {
            int idx= c- 'a';

            if( curr.children[idx] == null)
            {
                curr.children[idx]= new TrieNode();
            }

            curr= curr.children[idx];
        }

        curr.isWord= true;

    }

    public boolean search(String word) {

        TrieNode curr= root;

        for(char c : word.toCharArray())
        {
            int idx = c - 'a';

            if( curr.children[idx] == null)
            {
                break;
                
            }

            else
            {
                curr= curr.children[idx];
            }


        }

        return curr.isWord;

    }

    public boolean startsWith(String prefix) {

        TrieNode curr= root;

        for( char c: prefix.toCharArray())
        {
            int idx= c- 'a';
            if( curr.children[idx] == null)
            {
                return false;
            }

            else
            {
                curr= curr.children[idx];

            }


        }

        return true;

    }
}

class TrieNode
{
    TrieNode[] children = new TrieNode [26];
    private boolean isWord;

}
