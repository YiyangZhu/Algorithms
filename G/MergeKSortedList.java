package G;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    //use PriorityQueue, not thread-safe (PriorityBlockingQueue is thread-safe)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Comparator<ListNode> comp = Comparator.comparing(ListNode -> ListNode.val);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(comp);

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode node: lists){
            if(node != null){
                queue.offer(node);
            }
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;

            if(n.next != null){
                queue.offer((n.next));
                n = n.next;
            }
        }
        return head.next;
    }
}
