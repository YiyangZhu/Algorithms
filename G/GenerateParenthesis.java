package G;

import java.util.ArrayList;
import java.util.List;


public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        dfs(result, n, n,"");
        return result;
    }

    public static void dfs(List<String> result, int left, int right, String s){
        if(left > right){
            return;

        }
        if(left == 0 && right == 0){
            result.add(s);
        }
        if(left > 0){
            dfs(result, left - 1, right, s + "(");
        }
        if(right > 0){
            dfs(result, left, right - 1, s + ")");
        }
    }

}