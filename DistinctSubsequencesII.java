import java.util.HashSet;

public class DistinctSubsequencesII {


    public int distinctSubseqII(String S) {
        HashSet<String> set = new HashSet<>();
        count(S,set);
        for(int i = 0; i < S.length();i++){
            for(int j = i;j<S.length();j++){

            }
        }
        return set.size();
    }

    public void count(String S, HashSet<String> set){
        if(S.length() == 0){
            return;
        }
        set.add(S);
        for(int j = 0; j < S.length();j++){
            count(S.substring(0,j)+S.substring(j+1,S.length() ),set);
        }

    }
}
