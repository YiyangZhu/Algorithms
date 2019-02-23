package Trie;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LongestWordInDictionary {
    public static String longestWord(String[] words) {
        Trie trie = new Trie();

        Collections.sort(Arrays.asList(words), new Comparator<String>(){
            public int compare(String s1, String s2){
                if(s1.length() > s2.length()){
                    return -1;
                }
                if(s1.length() < s2.length()){
                    return 1;
                }

                int len = s1.length();
                for(int i = 0; i < len; i++){
                    if(s1.charAt(i) < s2.charAt(i)){
                        return -1;
                    }
                    if(s1.charAt(i) > s2.charAt(i)){
                        return 1;
                    }
                }
                return 0;
            }
        });

        System.out.println(Arrays.asList(words));

        for (String s : words) {
            trie.insert(s);
        }


        for (String s : words) {
            TrieNode node = trie.root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (node.children[c - 'a'] == null) {
                    break;
                }

                node = node.children[c - 'a'];
                if (!node.isWord) {
                    break;
                }
                if (i == s.length() - 1) {
                    return s;
                }
            }
        }

        return "";
    }
}