package G;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if(denominator == 0){
            return "";
        }

        String result = "";
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        long res = num / den;
        result += String.valueOf(res);

        long reminder = (num % den) * 10;

        if(reminder == 0){
            return result;
        }

        Map<Long, Integer> map = new HashMap<>();
        result += ".";
        while(reminder != 0){
            if(map.containsKey(reminder)){
                int beg = map.get(reminder);
                String part1 = result.substring(0,beg );
                String part2 = result.substring(beg,result.length() );
                result = part1 + "(" + part2 + ")";
                return result;

            }
            map.put(reminder,result.length());
            res = reminder / den;
            result += String.valueOf(res);
            reminder = (reminder % den) * 10;

        }
        return result;

    }
}