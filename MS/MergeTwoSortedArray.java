package MS;


public class MergeTwoSortedArray {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultP = new ListNode(0);
        ListNode head = resultP;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            while(l2 != null){
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        } else {
            while(l1 != null){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }
        return resultP.next;
    }
}
