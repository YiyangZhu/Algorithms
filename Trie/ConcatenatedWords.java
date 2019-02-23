package Trie;

import java.util.*;

public class ConcatenatedWords {


    public static List<String> findConcatenation(String[] words){
        List<String> result = new ArrayList<>();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()){
                    return 1;
                }
                if(o1.length() < o2.length()){
                    return -1;
                }

                return 0;
            }
        });

        HashSet<String> set = new HashSet<>();


        for(String s: words){
            if(form(s, set)){
                result.add(s);
            }
            set.add(s);
        }

        return result;
    }

    public static boolean form(String word, HashSet<String> set){
        if(set.isEmpty()){
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(!dp[j]){
                    continue;
                }
                if(set.contains(word.substring(j,i ))){
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[word.length()];
    }

    public static List<String> findConcatenationTrie(String[] words){
        List<String> result = new ArrayList<>();

        Trie trie = new Trie();
        for(String s: words){
            trie.insert(s);
        }

        int[] count = new int[1];
        count[0] = 0;

        for(String s: words){
            count[0] = 0;
            findComponentTrie(s, count, trie);
            if(count[0] > 1){
                result.add(s);
            }
        }
        return result;
    }

    public static int[] findComponentTrie(String word, int[] count, Trie trie){
        for(int i = 0; i < word.length(); i++){
            String left = word.substring(0,i );
            String right = word.substring(i );

            if(trie.search(left)){
                count[0]++;
                findComponentTrie(right,count,trie);
            }
        }
        return count;

    }
}
