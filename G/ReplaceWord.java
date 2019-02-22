package G;

import java.util.HashSet;
import java.util.List;

class ReplaceWord {
    public String replaceWords(List<String> dict, String sentence) {
        String[] array = sentence.split(" ");
        HashSet<String> set = new HashSet<>(dict);

        String result = "";
        for(String s: array){
            String newS = replace(s,set);
            result = result + " " + newS;
        }

        return result.trim();
    }

    public String replace(String s, HashSet<String> set){
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0,i+1);

            if(set.contains(sub)){
                return sub;
            }
        }
        return s;
    }
}