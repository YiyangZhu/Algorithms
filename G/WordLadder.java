package G;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        map.put(beginWord, 1);

        for(String word: wordList){
            set.add(word);
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()){
            String word = queue.removeFirst();

            for(int i = 0; i < word.length(); i++){
                String newWord = new String(word);
                for(char ch = 'a'; ch <= 'z'; ch++){
                    newWord = newWord.substring(0,i ) + ch + newWord.substring(i+1,newWord.length() );
                    if(set.contains(newWord) && newWord.equals(endWord)){
                        return map.get(word) + 1;
                    }
                    if(set.contains(newWord) && ! map.containsKey(newWord)){
                        queue.add(newWord);
                        map.put(newWord,map.get(word) + 1 );
                    }
                }
            }
        }
        return 0;
    }

}
