package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchTwo {

    HashSet<String> set;
    public List<String> findWords(char[][] board, String[] words) {
        set = new HashSet<>();

        Trie trie = new Trie();
        for(String s: words){
            trie.insert(s);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board,"",i,j,trie,visited);
            }
        }
        //System.out.println(set);
        return new ArrayList<>(set);
    }

    public void dfs(char[][] board, String s, int i, int j, Trie trie, boolean[][] visited){
        int m = board.length;
        int n = board[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j]){
            return;
        }

        s += board[i][j];
        if(!trie.startsWith(s)){
            return;
        }
        if(trie.search(s)){
            set.add(s);
        }

        visited[i][j] = true;
        dfs(board,s,i-1,j,trie,visited);
        dfs(board,s,i+1,j,trie,visited);
        dfs(board,s,i,j-1,trie,visited);
        dfs(board,s,i,j+1,trie,visited);
        visited[i][j] = false;
    }
}