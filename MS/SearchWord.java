package MS;

public class SearchWord {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                if(search(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board,int i, int j, String word, int index){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        } else if(index == word.length()-1){
            if(board[i][j] == word.charAt(index)){
                return true;
            } else {
                return false;
            }
        } else {
            if(board[i][j] != word.charAt(index)){
                return false;
            }
            char temp = board[i][j];
            board[i][j] = '0';
            if(search(board,i-1,j,word,index+1) || search(board,i+1,j,word,index+1) || search(board,i,j-1,word,index+1) || search(board,i,j+1,word,index+1)){
                return true;
            }
            board[i][j] = temp;
            return false;
        }
    }
}
