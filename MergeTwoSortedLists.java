public class MergeTwoSortedLists {


public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public static void main(String[] args){
    ListNode l1 = new ListNode(5);
    ListNode head1 = l1;
    ListNode l2 = new ListNode(1);
    ListNode head2 = l2;
    l2.next = new ListNode(2);
    l2 = l2.next;
    l2.next = new ListNode(4);
    mergeTwoLists(head1, head2);
}
    public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode result = new ListNode(Math.min(l1.val,l2.val));
        ListNode head = result;
        result.next = new ListNode(Math.max(l1.val,l2.val));
        result = result.next;
        while(l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            result.next = new ListNode(Math.min(l1.val,l2.val));
            result = result.next;
            result.next = new ListNode(Math.max(l1.val,l2.val));
            result = result.next;
        }
        if(l1.next == null){
            while(l2.next != null){
                l2 = l2.next;
                result.next = new ListNode(l2.val);
                result = result.next;
            }
        } else {
            while(l1.next != null){
                l1 = l1.next;
                result.next = new ListNode(l1.val);
                result = result.next;
            }
        }
        return head;
    }
}
