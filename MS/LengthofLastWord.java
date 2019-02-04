package MS;

public class LengthofLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.equals("") || s.length() < 1) {
            return 0;
        }
        s = s.trim();
        if (s.equals("")) {
            return 0;
        }
        String[] sArray = s.split(" ");
        return sArray[sArray.length - 1].length();
    }
}
