public class LongPalindromeSubSDP {
    public static void main(String[] args){
        String s = "a";
        System.out.println(longestPalindrome(s));
    }


    public static String longestPalindrome(String s) {
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

    public static boolean isPalindrome(String s){
        if(s.length() == 1 | s.length() == 0){
            return true;
        } else{
            if(s.charAt(0) != s.charAt(s.length()-1)){
                return false;
            } else {
                return isPalindrome(s.substring(1,s.length()-1));
            }
        }
    }
}
