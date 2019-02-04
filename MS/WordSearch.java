package MS;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println('5'-'0');
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        List<String> list1 = findWords(board, words);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null || board.length == 0 || board[0].length == 0 || words.length == 0) {
            return null;
        }


        char[][] originB = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                originB[i][j] = board[i][j];
            }
        }
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int x = 0; x < board.length; x++) {
                    for (int y = 0; y < board[0].length; y++) {
                        board[x][y] = originB[x][y];
                    }
                }
                for (int g = 0; g < words.length; g++) {
                    if (dfs(board, words[g], i, j, 0)) {
                        list1.add(words[g]);
                    }
                }
            }
        }
        return list1;
    }

    public static boolean dfs(char[][] m, String word, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= m.length || j >= m[0].length) {
            return false;
        }
        if (word.charAt(k) == m[i][j]) {
            if (k == word.length() - 1) {
                return true;
            }
            char current = m[i][j];
            m[i][j] = '-';
            if (dfs(m, word, i - 1, j, k + 1) || dfs(m, word, i + 1, j, k + 1) || dfs(m, word, i, j - 1, k + 1) || dfs(m, word, i, j + 1, k + 1)) {
                return true;
            }
            m[i][j] = current;
        }
        return false;
    }
}