package G;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        HashMap<Character, TrieNode> children = root.children;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            TrieNode t;

            if(children.containsKey(c)){
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c,t);
            }

            children = t.children;

            if(i == word.length() - 1){

                t.isLeaf = true;
            }
        }

    }

    public boolean search(String word) {
        TrieNode node = searchTrieNode(word);
        if(node != null && node.isLeaf){
            return true;
        } else {
            return false;
        }
    }

    public TrieNode searchTrieNode(String word){
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;


    }

    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!children.containsKey(c)){
                return false;
            } else {
                children = children.get(c).children;
            }
        }
        return true;
    }
}
