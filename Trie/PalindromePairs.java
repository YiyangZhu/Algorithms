package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        int len = words.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String s1 = words[i];
                String s2 = words[j];

                String pair1 = s1 + s2;
                String r1 = new StringBuilder(pair1).reverse().toString();
                if(pair1.equals(r1)){
                    ArrayList<Integer> current = new ArrayList<>(Arrays.asList(i,j));
                    result.add(current);
                }

                String pair2 = s2 + s1;
                String r2 = new StringBuilder(pair2).reverse().toString();
                if(pair2.equals(r2)){
                    ArrayList<Integer> current = new ArrayList<>(Arrays.asList(j,i));
                    result.add(current);
                }
            }
        }

        return result;
    }
}