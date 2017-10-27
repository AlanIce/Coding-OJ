class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (now.children[c - 'a'] == null)
                now.children[c - 'a'] = new TrieNode(c);
            now = now.children[c - 'a'];
        }
        now.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (now.children[c - 'a'] == null)
                return false;
            now = now.children[c - 'a'];
        }
        return now.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (now.children[c - 'a'] == null)
                return false;
            now = now.children[c - 'a'];
        }
        return true;
    }

    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode(char c){
            val = c;
        }
    }
}