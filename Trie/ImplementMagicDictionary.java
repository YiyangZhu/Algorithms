package Trie;

public class ImplementMagicDictionary {
    static String resultWord;

    public static boolean find(String[] wordDict, String word){
        Trie trie = new Trie();
        resultWord = "";
        for(String s: wordDict){
            trie.insert(s);
        }

        for(int i = 0; i < word.length(); i++){
            if(findWord(trie.root.children, word, i)){
                return true;
            }
        }
        return false;
    }

    public static boolean findWord(TrieNode[] children, String word,int i){
        int layer = i;
        int j = 0;
        while(layer > 0){
            char c = word.charAt(j);
            if(children[c-'a'] == null){
                return false;
            }
            //go to trie's next layer
            children = children[c-'a'].children;
            layer--;
        }
        char c = word.charAt(i);
        for(TrieNode node: children){
            if(node.c == c){
                continue;
            } else {
                if(containWord(node.children, word, i + 1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containWord(TrieNode[] children, String word, int i){
        for(int j = i; j < word.length(); j++){
            char c = word.charAt(i);
            if(children[c-'a'] == null){
                return false;
            }
            children = children[c-'a'].children;
            if(j == word.length() - 1){
                return true;
            }
        }
        return false;
    }
}
