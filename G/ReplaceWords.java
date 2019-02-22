public class ReplaceWords {
    class TrieNode {
        char ch;
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;

        TrieNode(char c){
            this.ch = c;
        }
    }

    class Trie {
        TrieNode root;

        public Trie(){
            root = new TrieNode('0');
        }

        public void insert(String word) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(node.children[c-'a'] == null){
                    node.children[c-'a'] = new TrieNode(c);
                }
                node = node.children[c-'a'];
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

        public String findPrefix(String word, int i, TrieNode node) {
            if(i == word.length()){
                return word;
            }
            char c = word.charAt(i);
            if(node.children.containsKey(c)){
                if(node.children.get(c).isWord){
                    return word.substring(0,i + 1);
                } else {
                    return findPrefix(word, i + 1, node.children.get(c));
                }
            }
            return word;
        }
    }

    class Solution {
        public String replaceWords(List<String> dict, String sentence) {
            String[] array = sentence.split(" ");
            Trie trie = new Trie();

            String result = "";
            for(String s: dict){
                trie.insert(s);
            }

            for(String s: array){
                String newS = trie.findPrefix(s,0,trie.root);
                result = result + " " + newS;
            }

            return result.trim();
        }
    }
}
