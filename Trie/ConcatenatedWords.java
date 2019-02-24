package Trie;

import java.util.*;

public class ConcatenatedWords {


    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                }
                if (o1.length() < o2.length()) {
                    return -1;
                }

                return 0;
            }
        });

        HashSet<String> set = new HashSet<>();


        for (String s : words) {
            if (form(s, set)) {
                result.add(s);
            }
            set.add(s);
        }

        return result;
    }

    public static boolean form(String word, HashSet<String> set) {
        if (set.isEmpty()) {
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }
                if (set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[word.length()];
    }

    public List<String> findAllConcatenatedWordsInADictUsingTrie(String[] words) {
        List<String> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (String s : words) {
            addWord(s, root);
        }

        for (String s : words) {
            if (s.equals("")) {
                continue;
            }
            if (find(s, 0, root, 0)) {
                result.add(s);
            }
        }
        return result;
    }

    public void addWord(String s, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            if (i == s.length() - 1) {
                node.isWord = true;
            }
        }
    }

    public boolean find(String s, int index, TrieNode root, int count) {
        TrieNode node = root;
        int n = s.length();
        for (int i = index; i < n; i++) {
            char c = s.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            if (node.children[c - 'a'].isWord) {
                if (i == n - 1) {
                    return count >= 1;
                }
                if (find(s, i + 1, root, count+1 )){
                    return true;
                }
            }
            node = node.children[c-'a'];
        }
        return false;
    }

    public class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }
}
