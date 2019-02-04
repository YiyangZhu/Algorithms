package MS;

public class SwapNodesinPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode second = first.next;
        ListNode newHead = second;
        ListNode previous = null;
        while(second.next != null){
            ListNode nextFirst = second.next;
            ListNode nextSecond = nextFirst.next;
            first.next = nextFirst;
            second.next = first;
            previous = first;
            first = nextFirst;
            second = nextSecond;
        }
        previous.next = second;
        second.next = first;
        first.next = null;
        return newHead;


    }
}
