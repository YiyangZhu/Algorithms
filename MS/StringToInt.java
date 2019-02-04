package MS;

public class StringToInt {
    public static void main(String[] args){
        String s =  "";
        System.out.println(myAtoi(s));


    }
    public static int myAtoi(String str) {
        if(str == ""){
            return 0;
        }
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        char flag = '+';
        if(str.charAt(0) == '-'){
            flag = '-';
            str = str.substring(1);
        } else if(str.charAt(0) == '+'){
            flag = '+';
            str = str.substring(1);
        }
        double result = 0;
        int i = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if(flag == '-'){
            result = -result;
        }
        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int)result;
    }
}
