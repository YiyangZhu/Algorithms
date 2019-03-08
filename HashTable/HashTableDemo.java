package HashTable;

import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(0, "Youngkey");
        table.put(1, "Ke");
        table.put(2, "YY");
        table.put(3, "Yummy");
        table.put(4, "houzi");
        for (int i : table.keySet()) {
            System.out.println(i + " " + table.get(i));
        }
    }
}
