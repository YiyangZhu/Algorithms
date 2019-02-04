package MS;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        if(s == null || s.equals("")){
            return true;
        }
        s = s.trim();
        if(s.equals("")){
            return true;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        boolean next = false;

        while(i < j){
            next = false;
            if(!alphNum(s.charAt(i))){
                i++;
                next = true;
            }
            if(!alphNum(s.charAt(j))){
                j--;
                next = true;
            }
            if(next){
                continue;
            } else {
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }

    public static boolean alphNum(char ch){
        if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'){
            return true;
        } else {
            return false;
        }
    }
}

