public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] array = new int[n + 1];
        for(int i = 0; i < n + 1;i++){
            array[i] = i;
        }
        for(int i = 0; i < n - 1; i++){
            if(S.charAt(i) == 'D' && array[i] < array[i+1]){
                int temp = array[i];
                array[i] = array[n];
                for(int j = n; j > i + 1; j--){
                    array[j] = array [j-1];
                }
                array[i + 1] = temp;
            }

        }
        if(S.charAt(n-1) == 'I' && array[n-1] > array[n] || S.charAt(n-1) == 'D' && array[n-1] < array[n]){
            swap(n-1,n,array);
        }
        return array;

    }

    public void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
