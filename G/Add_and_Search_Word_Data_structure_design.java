package G;

import java.util.HashMap;

public class Add_and_Search_Word_Data_structure_design {


    TrieNode root;

    /** Initialize your data structure here. */
    public Add_and_Search_Word_Data_structure_design() {
        root = new TrieNode('0');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                node.children.put(c,new TrieNode(c));
            }
            node = node.children.get(c);
            if(i == word.length() - 1){
                node.isWord = true;
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfsSearch(root.children, word, 0);
    }

    public boolean dfsSearch(HashMap<Character, TrieNode> children, String word, int i){
        int len = word.length();
        if(i == len){
            return false;
        }

        char c = word.charAt(i);
        if(children.containsKey(c)){
            if(i == len - 1 && children.get(c).isWord){
                return true;
            } else {
                return dfsSearch(children.get(c).children, word, i + 1);
            }
        } else if(c == '.'){
            for(TrieNode child: children.values()){
                if(i == len - 1 && child.isWord){
                    return true;
                }

                if(dfsSearch(child.children,word,i+1)){
                    return true;
                }
            }
            return false;

        } else {
            return false;
        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
