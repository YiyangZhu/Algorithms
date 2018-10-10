public class ImplementStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println("result = " + strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        if(haystack == null){
            return -1;
        }
        if(needle == null || needle.length() < 1){
            return 0;
        }
        if(haystack.length() < 1){
            return -1;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        int m = haystack.length();
        int n = needle.length();
        for(int i = 0; i < m - n + 1; i++){
            int k = i;
            for(int j = 0;j < n; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if(j == n - 1){
                    return k;
                }
            }
        }
        return -1;

    }
}
