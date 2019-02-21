package G;

import java.util.HashMap;

public class TrieNode {
    char ch;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;

    TrieNode(char c){
        this.ch = c;
    }
}
