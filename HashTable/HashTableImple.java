package HashTable;

public class HashTableImple {
    int[] table;
    String[] stringTable;

    public static class HashNode{
        int key;
        String value;
        HashNode(int k, String v){
            this.key = k;
            this.value = v;
        }
    }
    public static void main(String[] args) {
        HashTableImple h = new HashTableImple();
        h.insert(18);
        h.insert(9);
        h.search(200);
        h.search(9);
        h.put(new HashNode(0, "Youngkey"));
        h.put(new HashNode(1, "Ke"));
        h.put(new HashNode(2, "YY"));
        h.put(new HashNode(3, "Yummy"));
        h.put(new HashNode(4, "houzi"));
        System.out.println("h contains 3: "+h.containsKey(3));
        System.out.println("h contains 8: "+h.containsKey(8));
        System.out.println("h get key of 4: "+h.get(4));
        System.out.println("h get key of 10: "+h.get(10));
    }

    public HashTableImple() {
        table = new int[701];
        stringTable = new String[701];
    }

    public void insert(int i) {
        table[i % 701] = i;
    }

    public void put(HashNode node){
        stringTable[node.key % 701] = node.value;
    }

    public void delete(int i) {
        table[i % 701] = 0;
    }

    public void deleteString(HashNode node) {
        stringTable[node.key % 701] = null;
    }

    public void search(int i) {
        if (table[i % 701] != 0) {
            System.out.println("found " + i);
        } else {
            System.out.println(i + " does not exist in hash table");
        }
    }

    public String get(int i) {
        return stringTable[i % 701];
    }

    public boolean containsKey(int i){
        return stringTable[i % 701] != null;
    }
}
