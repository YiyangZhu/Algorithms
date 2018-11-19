public class ReverseLinkedLis {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head = reverseList(head);
        while(head!= null){
            System.out.println(head.val);
            head = head.next;
        }

    }
    public static ListNode reverseList(ListNode head) {
        if(head == null|| head.next == null){
            return head;
        }
        if(head.next.next == null){
            ListNode result = head.next;
            result.next = head;
            head.next = null;

            return result;
        }
        ListNode previous = head;
        ListNode current = head.next;
        ListNode nextNode = head.next.next;
        head.next = null;
        while(nextNode != null){
            current.next = previous;
            previous = current;
            current = nextNode;
            nextNode = nextNode.next;
        }
        ListNode result = current;
        current.next = previous;
        return result;
    }
}