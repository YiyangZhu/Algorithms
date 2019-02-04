package MS;

import java.util.HashMap;

public class HashMapPractice {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"John");
        map.put(2,"Mary");
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}
