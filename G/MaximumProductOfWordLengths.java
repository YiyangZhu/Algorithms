package G;

import java.util.HashSet;

public class MaximumProductOfWordLengths {

    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        HashSet[] setArray = new HashSet[words.length];
        for(int i = 0; i < words.length; i++){
            setArray[i] = new HashSet<Character>();
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                setArray[i].add(word.charAt(j));

            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String word1 = words[i];
                String word2 = words[j];
                HashSet<Character> set1 = setArray[i];
                HashSet<Character> set2 = setArray[j];
                int count = 0;
                for (Character ch : set1) {

                    if (set2.contains(ch)) {
                        break;
                    }
                    count++;
                }
                if(count == set1.size()){
                    result = Math.max(result, word1.length() * word2.length());
                }

            }
        }
        return result;
    }

    public static int maxProduct(String[] words) {
        
    }
}