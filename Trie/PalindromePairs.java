package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
    static ArrayList<List<Integer>> result;
    static HashMap<String, Integer> map;

    public static List<List<Integer>> palindromePairs(String[] words) {
        Trie trie = new Trie();
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
            trie.insert(words[i]);
        }

        result = new ArrayList<>();

        for(String s: words){
            findPairs(s,trie);
        }
        return result;
    }

    public static void findPairs(String s, Trie trie){
        for(int i = 0; i < s.length(); i++){
            String left = s.substring(0,i );
            String right = s.substring(i );
            if(isPalindrome(left)){
                if(trie.search((new StringBuilder(right)).reverse().toString())){
                    List<Integer> aPair = new ArrayList<>();
                    int i1 = map.get(s);
                    int i2 = map.get((new StringBuilder(right)).reverse().toString());
                    aPair.add(i1);
                    aPair.add(i2);
                    result.add(aPair);
                }
            }
        }
    }

    public static boolean isPalindrome(String s){
        int n = s.length();
        int mid = (n - 1) / 2;
        for(int i = 0; i <= mid; i++){
            int leftIndex = i;
            int rightIndex = n - 1 - i;
            if(s.charAt(leftIndex) != s.charAt(rightIndex)){
                return false;
            }
        }
        return true;
    }
}
