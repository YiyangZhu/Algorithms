package G;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterPhoneNumber {
    static HashMap<Character, char[]> map = new HashMap<>();
    static List<String> list;


    public static List<String> letterCombinations(String digits) {
        constructMap();
        list = new ArrayList<>();
        return letter(digits);

    }

    public static List<String> letter(String digits) {
        if(digits.length() == 0){
            return list;
        }
        List<String> newList = new ArrayList<>();

        char c = digits.charAt(0);
        char[] charArray = map.get(c);

        if(list.size() == 0){
            for(char c1: charArray){
                String newString = "" + c1;
                newList.add(newString);
            }
        } else {
            for(String s: list){
                for(char c1: charArray){
                    String newString = s + c1;
                    newList.add(newString);
                }
            }
        }
        list = newList;
        return letter(digits.substring(1 ));
    }


    public static void constructMap(){
        char[] charArray2 = {'a','b','c'};
        map.put('2', charArray2);

        char[] charArray3 = {'d','e','f'};
        char[] charArray4 = {'g','h','i'};
        char[] charArray5 = {'j','k','l'};
        char[] charArray6 = {'m','n','o'};
        char[] charArray7 = {'p','q','r','s'};
        char[] charArray8 = {'t','u','v'};
        char[] charArray9 = {'w','x','y','z'};

        map.put('3', charArray3);
        map.put('4', charArray4);
        map.put('5', charArray5);
        map.put('6', charArray6);
        map.put('7', charArray7);
        map.put('8', charArray8);
        map.put('9', charArray9);
    }
}
