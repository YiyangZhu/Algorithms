public class StringToInteger {
    public static void main(String[] args) {
        String s = " a";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        str = str.trim();
        if (str.equals("")) {
            return 0;
        }
        int i = 0;
        char flag = '+';
        if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            sb.append(str.charAt(i));
            i++;
        }
        if (sb == null || sb.length() < 1) {
            return 0;
        }
        double result = Double.parseDouble(sb.toString());
        if (flag == '-') {
            result = -result;
        }
        if (result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
    