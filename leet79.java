public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i= 0;i< board.length;i++){
            for(int j = 0 ;j < board[0].length;j++){
                if(existHelper(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    public boolean existHelper(char [][] board, int i, int j, String w, int index){
        if(index == w.length()) return true;
        if(i<0 || j<0 || i==board.length || j==board[0].length) return false;
        if(board[i][j]!=w.charAt(index)) return false;
        board[i][j] ^=256;
        boolean exist = existHelper(board,i,j+1,w,index+1)
            || existHelper(board,i,j-1,w,index+1)
            || existHelper(board,i+1,j,w,index+1)
            || existHelper(board,i-1,j,w,index+1);
        board[i][j] ^=256;
        return exist;
    }
}public class Solution {
    class TrieNode{
        List<String> startWith;
        TrieNode [] children;
        TrieNode(){
            startWith = new ArrayList();
            children = new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        Trie(String[] words){
            root = new TrieNode();
            for(String word: words){
                TrieNode cur = root;
                for(char c : word.toCharArray()){
                    int index = c-'a';
                    if(cur.children[index]==null){
                        cur.children[index] = new TrieNode();
                    }
                    cur.children[index].startWith.add(word);
                    cur = cur.children[index];
                }
            }
        }
        
        List<String> findByPrefix(String prefix){
            TrieNode cur = root;
            List<String> res = new ArrayList();
            for(char a:prefix.toCharArray()){
                if(cur.children[a-'a']==null)  return res;
                cur = cur.children[a-'a'];
            }
            res.addAll(cur.startWith);
            return res;
        }
        
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList();
        if (words == null || words.length == 0)
            return res;
        Trie tr = new Trie(words);
        List<String> temp = new ArrayList();
        int length = words[0].length();
        for(String str:words){
            temp.add(str);
            backtrack(res,temp,length,tr);
            temp.remove(temp.size()-1);
        }
        return res;
        
    }
    public void backtrack(List<List<String>> res, List<String> temp, int length, Trie tr){
        if(temp.size()==length){
            res.add(new ArrayList(temp));
            return;
        }
        int index = temp.size();
        StringBuilder sb = new StringBuilder();
        for(String str: temp){
            sb.append(str.charAt(index));
        }
        List<String> startWith = tr.findByPrefix(sb.toString());
        for(String s : startWith){
            temp.add(s);
            backtrack(res,temp,length,tr);
            temp.remove(temp.size()-1);
        }
        
    }
}