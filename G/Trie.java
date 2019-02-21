package G;

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode('0');
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                node.children.put(c,new TrieNode(c) );
            }
            node = node.children.get(c);
            if(i == word.length()-1){
                node.isWord = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode node = searchTrieNode(word);
        return node != null && node.isWord;

    }

    public TrieNode searchTrieNode(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                return null;
            }
            node = node.children.get(c);
            if(i == word.length() - 1){
                return node;
            }
        }
        return null;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchTrieNode(prefix);
        return node != null;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */