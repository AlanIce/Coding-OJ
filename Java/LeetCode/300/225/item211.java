class WordDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (now.children[c - 'a'] == null)
                now.children[c - 'a'] = new TrieNode(c);
            now = now.children[c - 'a'];
        }
        now.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode now) {
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (c == '.') {
                String subStr = word.substring(i + 1);
                for (int j = 0; j < 26; j++)
                    if (now.children[j] != null && search(subStr, now.children[j]))
                        return true;
                return false;

            }
            if (now.children[c - 'a'] == null)
                return false;
            now = now.children[c - 'a'];
        }
        return now.isWord;
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