class TrieNode
{
    private TrieNode children[] = new TrieNode [26];
    private boolean isEndofWord;
}

class WordDictionary {

    private TrieNode  root;

    public WordDictionary() {

        root= new TrieNode();

    }

    public void addWord(String word) {

        TrieNode curr= root;

        for(char c: word.toCharArray())
        {
            int idx = c - 'a';

            if( curr.children[idx] == null)
            {
                curr.children[idx]= new TrieNode();
            }

            curr= curr.children[idx];
        }

        curr.isEndofWord= true;

    }

    public boolean search(String word) {

        return dfs(word,0,root);
    }

    private boolean dfs(String word,int index, TrieNode root)
    {
        TrieNode curr= root;

        for(int i= index; i < word.length(); i++)
        {
            char c= word.charAt(i);

            if( c == '.')
            {
                for( TrieNode child: curr.children)
                {
                    if( child !=null && dfs(word,i+1,child))
                    {
                        return true;
                    }
                }

                return false;


            }

            else
            {
                int idx= c -'a';

                if( curr.children[idx] == null)
                {
                    return false;
                }

                curr= curr.children[idx];


            }

        }

        return curr.isEndofWord;

    }
}
