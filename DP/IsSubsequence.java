package DP;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null){
            return false;
        }

        if(s.equals("")){
            return true;
        }

        char[] sArray = t.toCharArray();
        char[] tArray = s.toCharArray();

        int i = 0;
        int j = 0;

        for(j = 0; j < tArray.length; j++){
            while(i < sArray.length){
                if(sArray[i] == tArray[j]){
                    if(j == tArray.length - 1){
                        return true;
                    } else {
                        i++;
                        break;
                    }
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}