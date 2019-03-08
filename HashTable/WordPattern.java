package HashTable;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(str == null){
            return false;
        }
        String[] strArray = str.trim().split(" ");
        if(strArray.length != pattern.length()){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for(int i = 0; i < pattern.length();i++){
            char c = pattern.charAt(i);
            String s = strArray[i];
            if(map.containsKey(c)){
                if(!map.get(c).equals(s)){
                    return false;
                }
            } else {
                map.put(c,s);
            }

            if(map2.containsKey(s)){

                if(!map2.get(s).equals(c)){
                    return false;
                }
            } else {
                map2.put(s,c);
            }
        }
        return true;
    }
}
