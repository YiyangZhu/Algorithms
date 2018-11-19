import java.util.ArrayList;
import java.util.List;

public class FindtheShortestSuperstring {
    List<String> stringList = new ArrayList<>();

    public String shortestSuperstring(String[] A) {

        return "";
    }

    public void permutate(int i, String[] A, String superString){
        if(i >= A.length){
            stringList.add(superString);
            return;
        }


    }

    public String getMinSuperString(String s1, String s2){
        String result = "";
        String first = "";
        String second = "";
        for(int i = 0; i < Math.min(s1.length(),s2.length());i++){
            if(s1.charAt(i) == s2.charAt())
        }

        return result;
    }

    public void swap(int i, int j, String[] A){
        String temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}