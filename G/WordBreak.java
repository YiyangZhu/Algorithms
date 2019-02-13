package G;

import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;

        for(int i = 0; i < s.length(); i++){
            if(!t[i]){
                continue;
            }

            for(String a: wordDict){
                int len = a.length();
                int end = len + i;

                if(end > s.length() || t[end]){
                    continue;
                }
                if(s.substring(i,end ).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }


    public static boolean wordBreakRecursion(String s, List<String> wordDict) {
        return wordBreakHelper(s,wordDict,0);
    }

    public static boolean wordBreakHelper(String s, List<String> wordDict, int i){
        if(i == s.length()){
            return true;
        }

        for(String a: wordDict){
            int len = a.length();
            int end = len + i;

            if(end > s.length()){
                continue;
            }
            if(s.substring(i,end ).equals(a)){
                if(wordBreakHelper(s,wordDict , end)){
                    return true;
                }
            }
        }

        return false;

    }
}

