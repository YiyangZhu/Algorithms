import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;


public class WordLadder {
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            System.out.println("word=" + word);
            System.out.print("queue has: ");
            for (String s : queue) {

                System.out.print(s + " ");
            }
            System.out.println();
            curNum--;
            System.out.println("curNum=" + curNum);
            for (int i = 0; i < word.length(); i++) {
                System.out.println("i=" + i);
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    System.out.println("j=" + j);
                    String temp = new String(wordUnit);
                    System.out.println("temp=" + temp);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return level + 1;
                        }
                        nextNum++;
                        System.out.println("nextNum=" + nextNum);
                        queue.offer(temp);
                        set.remove(temp);
                        System.out.print("queue has: ");
                        for (String s : queue) {
                            System.out.print(s + " ");
                        }
                        System.out.println();
                        System.out.println("set has" + set);
                        break;
                    }
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
            System.out.println();
        }

        return 0;

    }
}
