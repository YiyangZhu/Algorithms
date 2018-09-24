import java.util.HashMap;

public class IntegerToEnglishWords {
    static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        int i = 12345780;
        System.out.println(numberToWords(i));
    }

    public static String numberToWords(int num) {
        fillMap();
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            return map.get(0);
        }
        if (num >= 1000000000) {
            sb.append(convert(num / 1000000000) + " Billion");
            num = num % 1000000000;
        }

        if (num >= 1000000) {
            sb.append(convert(num / 1000000) + " Million");
            num = num % 1000000;
        }
        if (num > 1000) {
            sb.append(convert(num / 1000) + " Thousand");
            num = num % 1000;
        }
        if (num != 0) {
            sb.append(convert(num));
        }

        return sb.toString().trim();


    }

    public static String convert(int num) {
        StringBuilder sb2 = new StringBuilder();
        if (num >= 100) {
            sb2.append(" " + map.get(num / 100) + " Hundred");
            num = num % 100;
        }
        if (num > 0) {
            if (num <= 20) {
                sb2.append(" " + map.get(num));
            } else {
                sb2.append(" " + map.get(num - num % 10));
                if (num % 10 != 0) {
                    sb2.append(" " + map.get(num % 10));
                }
            }

        }
        return sb2.toString();
    }


    public static void fillMap() {
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }
}
