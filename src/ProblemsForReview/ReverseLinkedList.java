package ProblemsForReview;

/**
 * Created with IntelliJ IDEA.
 * User: JT026354
 * Date: 12/22/13
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseLinkedList {
    /**Reverse the linked iterating way**/
    public static ListNode reverseOrder(ListNode head) {

        //Check for empty list or list with only one element
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        //set the old head to tail
        head.next = null;

        return pre;
    }

    public static ListNode recursiveReverseOrder(ListNode head)
    {
        //Check for empty list
        if(head == null)
            return head;

        // Check if we are at the tail node
        if(head.next == null)
        {
            //set head to current tail since we are reversing list
            return head;
        }

        ListNode newHead = recursiveReverseOrder(head.next);
        head.next.next = head;
        head.next = null; //set "old" next pointer to NULL

        return newHead;
    }

    public static void printList(ListNode n) {
        System.out.println("------");
        while (n != null) {
            System.out.print(n.val);
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printList(n1);

        reverseOrder(n1);

        printList(n4);

        recursiveReverseOrder(n4);

        printList(n1);

    }
}
