package Leetcode;
import Util.*;
/*	Rotate List: 
 *	Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 *	For example:
 *	Given 1->2->3->4->5->NULL and k = 2,
 *	return 4->5->1->2->3->NULL.
 */
public class RotateList {

	public static ListNode rotateRight(ListNode head, int n) {
	        if(head == null) return head; 
        
        	ListNode counter = head;    
	        int length = 0; 
        	while(counter != null){
            	counter =counter.next;
	            length++; 
        	}
        
	        if(length == n) 
        	    return head; 
	        else if(length < n)
        	    n = n % length;
	        if(n == 0) return head;
        
		ListNode curr = head; 
		ListNode runner = curr; 
        	for(int i = 0; i < n; i++) {
			runner = runner.next; 
        	}	 
		while(runner.next != null){
			curr = curr.next; 
			runner = runner.next;
		}
		ListNode  NewHead = curr.next; 
		curr.next = null;
		runner.next = head; 
		return NewHead;     
	}
}
