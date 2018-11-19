public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        int count = 0;
        int n = A[0].length();
        for(int j = 0; j < n; j++){
            for(int i = 0; i < A.length - 1;i++){
                if(A[i].charAt(j) > A[i+1].charAt(j)){
                    count++;
                    break;
                }
            }
        }
        return count;


    }
}
