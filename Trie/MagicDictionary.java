package Trie;

public class MagicDictionary {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s: dict){
            TrieNode node = root;
            for(char c: s.toCharArray()){
                if(node.children[c-'a'] == null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isWord = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] a1 = word.toCharArray();
        for(int i = 0; i < a1.length; i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == a1[i]){
                    continue;
                }
                char temp = a1[i];
                a1[i] = c;
                if(containsWord(new String(a1),root)){
                    return true;
                }
                a1[i] = temp;
            }
        }
        return false;
    }

    public boolean containsWord(String s, TrieNode root) {
        TrieNode node = root;
        for(char c: s.toCharArray()){
            if(node.children[c-'a'] == null){
                return false;
            }
            node = node.children[c-'a'];
        }
        return node.isWord;
    }
}