package MS;

import java.util.HashMap;
import java.util.HashSet;

public class IntersectionLinkedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        ListNode list2 = new ListNode(2);
        list2.next = list1;
        System.out.println(getIntersectionNode(list1,list2));

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode aNode = headA;
        ListNode bNode = headB;
        HashSet set1 = new HashSet();
        while(aNode != null){
            set1.add(aNode.val);
            aNode = aNode.next;
        }
        while(bNode != null){
            if(set1.contains(bNode.val)){
                return bNode;
            }
            bNode = bNode.next;
        }
        return null;


    }


}
