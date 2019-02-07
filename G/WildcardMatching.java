package G;

public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int iIndex = -1;
        int starIndex = -1;

        while(i < s.length() ){
            if(j < p.length() && ((p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)))){
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*'){
                starIndex = j;
                iIndex = i;
                j++;
            } else if(starIndex != -1){
                j = starIndex;
                i = iIndex + 1;
                iIndex++;
            } else {
                return false;
            }
        }

        while(j < p.length() && p.charAt(j) == '*'){
            j++;
        }

        return j == p.length();
    }
}