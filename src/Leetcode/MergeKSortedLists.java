package Leetcode;

/*Merge K sorted list
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * input											expected	
	[]												{}	
	   
	[{}]											{}	
	   
	[{1}]											{1}	
	   
	[{0,2,5}]										{0,2,5}	
	   
	[{},{}]											{}	
	   
	[{},{1}]										{1}	
	   
	[{},{-1,5,11},{},{6,10}]						{-1,5,6,10,11}
		   
	[{0,0,0},{1,3,4,6}]								{0,0,0,1,3,4,6}	
	   
	[{-2,1,4,5},{-2,5,6},{-2,0}]					{-2,-2,-2,0,1,4,5,5,6}	
	   
	[{},{-1,5},{1,4,6},{4,5,6}]						{-1,1,4,4,5,5,6,6}	
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * */

import Util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	/*
	 * O(n): n*k
	 * */
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode ret = null, curr = null;	
        
        while(!lists.isEmpty())
        {
            int min = Integer.MAX_VALUE; 
            ListNode lnMin = null; 
            ArrayList<ListNode> NullNodes = new ArrayList<ListNode> ();
            for(ListNode ln : lists)
            {
            	/*Notes: null check*/
            	if(ln == null)
            		NullNodes.add(ln);
            	else if(ln.val < min)
                {
                    min = ln.val; 
                    lnMin = ln; 
                }
            }
            
            /*Notes: null check*/
            if(!NullNodes.isEmpty())
            {
            	for(ListNode NullNode : NullNodes)
            	{
            		lists.remove(NullNode);
            	}
            	
            }
            
            if(lnMin != null)
            {
	            lists.remove(lnMin);
	            if(lnMin.next != null)
	                lists.add(lnMin.next);
	            
	            ListNode NewNode = new ListNode(lnMin.val); 
	            
	            if(ret == null)
	            {
	                ret = NewNode; 
	                curr = NewNode;
	            }
	            else
	            {
	                curr.next = NewNode; 
	                curr = NewNode;
	            }
            }
        }
        
        return ret;
    }
	
	/*
	 * Using PriorityQueue
	 * O(n): nlogk(add each element to priorityQueue) + nlogk(find min element and remove it from priorityQueue) + n(add each element to result list) = nlogk
	 * 
	 * remove minimum from 
	 *
	 *  
	 *  notes: remove the minimum element from minheap: http://www.algolist.net/Data_structures/Binary_heap/Remove_minimum
	 *  	   insert an element into a minheap: http://www.algolist.net/Data_structures/Binary_heap/Insertion
	 * */
	 public ListNode mergeKLists2(ArrayList<ListNode> lists) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if (lists == null || lists.isEmpty())
	        return null;

	    Comparator<ListNode> comparator = new Comparator<ListNode>() {
	        @Override
	        public int compare(ListNode n1, ListNode n2) {
	            if (n1.val < n2.val)
	                return -1;
	            else if (n1.val > n2.val)
	                return 1;
	            else
	                return 0;
	        }
	    };

	    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
	    ListNode head = null;
	    ListNode cur = null;
	    for (int i = 0; i < lists.size(); i++) {
	        ListNode node = lists.get(i);
	        if (node != null)
	            heap.add(lists.get(i));
	    }
	    while(!heap.isEmpty()) {
	        if (head == null) {
	            head = heap.poll();
	            cur = head;
	            if (cur.next != null)
	                heap.add(cur.next);
	        } else {
	            ListNode newNode = heap.poll();
	            cur.next = newNode;
	            cur = newNode;
	            if (cur.next != null)
	                heap.add(cur.next);
	        }
	    }

	    return head;
	        
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
