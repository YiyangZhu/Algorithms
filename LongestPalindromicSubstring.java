public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.equals("") || s.length() == 1){
            return s;
        }
        String result = s.substring(0,1);
        int maxLength = 1;
        for(int i = 0; i < s.length();i++){
            for(int j = i; j < s.length();j++){
                if(isPalindrome(s.substring(i,j))){
                    if(j-i+1 > maxLength){
                        maxLength = j-i+1;
                        result = s.substring(i,j+1);
                    }
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s1){
        for(int i = 0; i < s1.length()/ 2;i++){
            if(s1.charAt(i) != s1.charAt(s1.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
/*
if(s.length() == 0 | s.length() == 1){
            return s;
        }
        String lp = "";
        int n = s.length();
        int start = 0;
        int maxLength = 1;
        boolean[][] table = new boolean[n][n];
        for (int i = 0; i < n; i++){
            table[i][i] = true;
        }
        for(int i = 0; i < n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for(int k = 3; k <= n;k++){
            for(int i = 0; i < n-k+1;i++){
                int j = i + k - 1;
                if(table[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    table[i][j] = true;
                    if(k>maxLength){
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }
}
 */
