public class ValidP {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s1));
        System.out.println();
        System.out.println((int)',');
        System.out.println((int)'0');
        System.out.println((int)'9');
        System.out.println((int)'A');
        System.out.println((int)'Z');

    }

    public static boolean isPalindrome(String s) {
        if(s.equals("") || s == null){
            return true;
        }
        s = s.trim().toUpperCase();
        if(s.equals("")){
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        boolean next = false;
        while(i <= j){
            System.out.println(s.charAt(i));
            System.out.println(s.charAt(j));
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
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean alphNum(char c){
        if(c<='Z' && c >='A'|| c <='9' && c >='0'){
            return true;
        }
        return false;
    }
}
