package G;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class WordBreak {
    static Comparator<String> comp = Comparator.comparing(String->String.length());
    static PriorityQueue<String> queue;
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null){
            return false;
        }

        queue = new PriorityQueue<>(comp.reversed());
        for(String s1: wordDict){
            queue.offer(s1);
        }


        return dfs(s,queue);

    }

    public static boolean dfs(String s, PriorityQueue<String> wordDict){
        if(s.equals("")){
            return true;
        } else {
            for(String word: wordDict){
                int n = word.length();
                String currentS = s;
                if(s.length()>= n && s.substring(0,n ).equals(word)){
                     if(dfs(s.substring(n),wordDict)){
                         return true;
                     }
                }
                s = currentS;
            }
            return false;
        }

    }

}
