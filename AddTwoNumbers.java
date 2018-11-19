public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int next = 0;
        ListNode head = new ListNode(0);
        ListNode result = head;
        while(l1 != null && l2 != null){
            ListNode current = new ListNode((l1.val + l2.val + next) % 10 );
            head.next = current;
            head = current;
            if((l1.val + l2.val + next) / 10 == 1){
                next = 1;
            } else {
                next = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null){
            while(l2 != null){
                ListNode current = new ListNode(( l2.val + next) % 10);
                head.next = current;
                head = current;
                if((l2.val + next) / 10 == 1){
                    next = 1;
                } else {
                    next = 0;
                }
                l2 = l2.next;
            }
        } else {
            while(l1 != null){
                ListNode current = new ListNode((l1.val+ next) % 10);
                head.next = current;
                head = current;
                if((l1.val + next) / 10 == 1){
                    next = 1;
                } else {
                    next = 0;
                }
                l1 = l1.next;
            }
        }
        if(next == 1){
            head.next = new ListNode(1);
        }
        return result.next;
    }
}
