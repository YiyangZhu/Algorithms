import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head;
    Node end;

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            map.remove(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void remove(Node node){
        if(node.pre != null){
            node.next.pre = node.pre;
        } else {
            head = node.next;
            head.pre = null;
        }
        if(node.next != null){
            node.pre.next = node.next;
        } else {
            end = node.pre;
            end.next = null;
        }
    }

    public void setHead(Node node){
        node.next = head;
        node.pre = null;
        if(head != null){
            head.pre = node;
        }
        if(end == null){
            end = head;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            oldNode.value = value;
            remove(oldNode);
            setHead(oldNode);
        } else {
            Node newNode = new Node(key,value );
            if(map.size() >= capacity){
                map.remove(end.key);
                remove(end);
            }
            map.put(key,newNode );
            setHead(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

