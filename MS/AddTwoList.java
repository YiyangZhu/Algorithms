package MS;

public class AddTwoList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode head1 = l1;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);
        l1 = l1.next;



        ListNode l2 = new ListNode(5);
        ListNode head2 = l2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);
        l2 = l2.next;
        l2.next = new ListNode(1);
        l2 = l2.next;

        ListNode result = addTwoNumbers(head1, head2);
        displayListNode(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        int current = l1.val + l2.val;
        int nextLoop = current / 10;
        l1.val = current % 10;
        while(l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            current = l1.val + l2.val + nextLoop;
            nextLoop = current / 10;
            l1.val = current % 10;
        }
        if (l1.next == null && l2.next == null){
            if (nextLoop == 1){
                l1.next = new ListNode(1);
            }
            return head1;
        } else if(l2.next == null){

            while(l1.next != null){
                l1 = l1.next;
                current = l1.val + nextLoop;
                nextLoop = current / 10;
                l1.val = current % 10;
            }
            if (nextLoop == 1){
                l1.next = new ListNode(1);
            }
            return head1;
        } else {
            l1.next = l2.next;

            while(l1.next != null){
                l1 = l1.next;
                current = l1.val + nextLoop;
                nextLoop = current / 10;
                l1.val = current % 10;
            }
            if (nextLoop == 1){
                l1.next = new ListNode(1);
            }
            return head1;
        }
    }

    public static void displayListNode(ListNode result) {
        while (result.next != null) {
            System.out.print(result.val);
            System.out.print("->");
            result = result.next;
        }
        System.out.println(result.val);
        System.out.println();
    }

}
