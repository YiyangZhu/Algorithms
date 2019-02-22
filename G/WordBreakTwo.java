package G;

import java.util.ArrayList;
import java.util.List;

public class WordBreakTwo {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(dp[i] == null){
                continue;
            }
            for(String a: wordDict){
                int len = a.length();
                int end = len + i;
                if(end > n){
                    continue;
                }

                if(s.substring(i,end ).equals(a)){
                    if(dp[end] == null){
                        dp[end] = new ArrayList<>();
                    }
                    dp[end].add(a);
                }
            }
        }

        List<String> result = new ArrayList<>();
        if(dp[n] == null){
            return result;
        }

        ArrayList<String> temp = new ArrayList<>();
        dfs(dp,n,result,temp);

        return result;
    }

    public static void dfs(List<String>[] dp, int end,  List<String> result ,  List<String> temp){
        if(end <= 0){
            String path = temp.get(temp.size()-1);
            for(int i = temp.size() - 2; i >= 0; i--){
                path += " " + temp.get(i);
            }
            result.add(path);
            return;
        }
        for(String str: dp[end]){
            temp.add(str);
            dfs(dp,end - str.length(),result,temp );
            temp.remove(temp.size() - 1);
        }
    }
}
