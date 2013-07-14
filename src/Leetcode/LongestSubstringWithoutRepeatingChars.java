package Leetcode;

import Util.*; 
/*	Longest Substring Without Repeating Characters: 
	Given a string, find the length of the longest substring without repeating characters.
	For example, the longest substring without repeating letters for "abcabcbb" is "abc",
	 which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
	
	example: 
	"abcabcbb"  =>	3
	"" 	    => 	0
	"abcddcbae" =>	5
*/

/*
you would need two indices to record the head and the tail of the current substring. 
Since i and j both traverse at most n steps, the worst case would be 2n steps, 
which the run time complexity must be O(n).
*/
public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] CharS = s.toCharArray();
        int n = s.length(); 
        int i = 0, j = 0; 
        int MaxLength = 0; 
        boolean[] exist = new boolean[256]; 
        while(j < n) {
            if(exist[CharS[j]]) {
                if (MaxLength < j-i) MaxLength = j-i; 
                while(CharS[i] != CharS[j]) {
                    exist[CharS[i]] = false; 
                    i++; 
                }
                i++;
            }else {
                exist[CharS[j]] = true;  
            }
            j++; 
        } 
        if(MaxLength < n-i) MaxLength = n-i; 
        return MaxLength; 
    }	

    /*
     * Follow up: using circular list instead of string as a input. 
     * circular list: a->b->c->d->e->c->f->g->h->a
     * */
    
	public static int lengthOfLongestSubSequence(ListNode s) {
		int MaxLength = 0; 
		boolean[] exist = new boolean[256];
 		ListNode tail = s, head = s; 
		exist[tail.val] = true;
		tail = tail.next; 
		while(tail != s) {
			if(exist[tail.val]) {
				if (MaxLength < distanct(head, tail)) MaxLength = distanct(head, tail);
				while(head.val != tail.val) {
					exist[head.val] = false;
					head = head.next; 
				}
				head = head.next; 
			} else {
				exist[tail.val] = true; 
			}
			tail = tail.next; 
		}
		if(MaxLength < distanct(head, s)) MaxLength = distanct(head, s); 
		return MaxLength; 
	} 
	
	public static int distanct(ListNode s, ListNode e) {
		int ret = 0; 
		while(s != e) {
			s = s.next; 
			ret++; 	
		} 
		return ret;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(5);
		ListNode l7 = new ListNode(6);
		ListNode l8 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l1;
	
		System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubSequence(l1));
	}

}
