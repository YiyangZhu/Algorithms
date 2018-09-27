import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode merge(ListNode[] lists){
        if(lists == null || lists.length < 1){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(ListNode list: lists){
            if(list!= null){
                queue.offer(list);
            }
        }
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if(node.next != null) {
                queue.offer(node.next);
            }
        }
        return head.next;
    }
}
