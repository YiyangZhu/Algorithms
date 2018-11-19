public class TitleToNumber {
    public static void main(String[] args) {
        String s1 = "A";
        String s2 = "AB";
        String s3 = "ZY";
        System.out.println(titleToNumber(s1));
        System.out.println(titleToNumber(s2));
        System.out.println(titleToNumber(s3));


    }

    public static int titleToNumber(String s) {
        int result = 0;
        int k = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result = result + (int) (s.charAt(i) - 'A'+1) * (int) Math.pow(26,k);
            k++;
        }
        return result;

    }
}
