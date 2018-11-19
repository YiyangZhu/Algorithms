public class LongPalindromeSubSBF {
    public static void main(String[] args){
        String s = "forgeeksskeegfor";
        System.out.println(longestPalindrome(s));
    }


    public static String longestPalindrome(String s) {
        String lP = "";
        for(int i = 0; i < s.length();i++){
            for(int j = i+1; j <= s.length();j++){
                String current = s.substring(i,j);
                if (isPalindrome(current)){
                    if (lP.length() < current.length()){
                        lP = current;
                    }
                }
            }
        }
        return lP;
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
