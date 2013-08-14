package Leetcode;
import Util.ListNode;

/*  Partition list:
*   Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.


* */

public class PartitionList {
	
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;

        ListNode p = head, q = head, pre = null, tail;
        while(q.next != null) {
            q = q.next;
        }
        tail = q;
       
        while(p != q) {
            if(p.val >= x) {
                ListNode pNext = p.next;
                if(head == p)
                    head = pNext;
                else
                    pre.next = p.next;
                tail.next = p;
                p.next = null;
                tail = p;
                p = pNext;
            } else {
                pre = p;
                p = p.next;
            }
        }
       
        if(p.val >= x && q != tail) {
            ListNode pNext = p.next;
            if(head == p)
                head = pNext;
            else
                pre.next = p.next;
            tail.next = p;
            p.next = null;
        }
        return head;
    }
}
