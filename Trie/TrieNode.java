package Trie;

public class TrieNode {

    char c;
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;

    TrieNode(){

    }

    TrieNode(char c){
        this.c = c;
    }
}
