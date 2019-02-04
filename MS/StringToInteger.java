package MS;

public class StringToInteger {


    public int myAtoi(String str) {
        if(str == null){
            return 0;
        }
        str = str.trim();
        if(str.equals("")){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char flag = '+';
        if(str.charAt(0) == '+'){
            index++;
        } else if(str.charAt(0) == '-'){
            flag = '-';
            index++;
        }
        while(index < str.length() && str.charAt(index) <= '9' && str.charAt(index) >= 0){
            sb.append(str.charAt(index));
            index++;
        }
        if(sb.toString().equals("")){
            return 0;
        }
        double result = Double.parseDouble(sb.toString());
        if(flag == '-'){
            result = -result;
        }
        int resultInt = 0;
        if (result >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if(result<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        resultInt = (int) result;
        return resultInt;
        }
}
    