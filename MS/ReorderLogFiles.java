package MS;

import java.util.ArrayList;
import java.util.List;

public class ReorderLogFiles {
    public static void main(String[] args){
        String[] sArray = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        reorderLogFiles(sArray);
    }

    public static void reorderLogFiles(String[] logs) {
        String[] sArray = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        List<String[]> list = new ArrayList<>();
        for(String s: sArray){
            list.add(s.split(" "));
        }
        System.out.println(list);

    }
}
