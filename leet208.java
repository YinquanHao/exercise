public class Trie {
    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode rt = root;
        for(int i=0;i<word.length();i++){
            char s = word.charAt(i);
            if(rt.children[s-'a']==null){
                rt.children[s-'a']= new TrieNode(s);
            }
            rt = rt.children[s-'a'];
        }
        rt.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode rt = root;
        for(int i=0;i<word.length();i++){
            char s = word.charAt(i);
            if(rt.children[s-'a']==null){
                return false;
            }
            rt = rt.children[s-'a'];
        }
        return rt.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode rt = root;
        for(int i=0;i<prefix.length();i++){
            char s = prefix.charAt(i);
            if(rt.children[s-'a']==null){
                return false;
            }
            rt = rt.children[s-'a'];
        }
        return true;
    }
}

class TrieNode{
    public char val;
    public boolean isWord = false;
    TrieNode [] children = new TrieNode[26];
    public TrieNode(){}
    public TrieNode(char c){
        this.val = c;
        TrieNode node = new TrieNode();
    }
}
