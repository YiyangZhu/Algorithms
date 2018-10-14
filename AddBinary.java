public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        if (a == null || a.length() < 1) {
            return b;
        }
        if (b == null || b.length() < 1) {
            return a;
        }
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        while (indexA >= 0 || indexB >= 0) {
            int curA = 0;
            int curB = 0;
            System.out.println(a.charAt(indexA) == 65);
            System.out.println(b.charAt(indexB) == 65);
            if (indexA >= 0) {
                curA = a.charAt(indexA) == '0' ? 0 : 1;
            }
            if (indexB >= 0) {
                curB = b.charAt(indexB) == '0' ? 0 : 1;
            }
            int current = curA + curB + flag;
            if (current >= 2) {
                sb.append(String.valueOf(current - 2));
                flag = 1;
            } else {
                sb.append(String.valueOf(current));
                flag = 0;
            }
            indexA--;
            indexB--;
        }
        if (flag == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}

