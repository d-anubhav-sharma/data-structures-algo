package com.driver;

import com.logger.DLogger;

public class LinkedListInsertionSort {
	
	public static void main(String[] args) {
		
		ListNode node = new ListNode(4, 
				new ListNode(2, 
				new ListNode(1,
				new ListNode(3, null))));
		ListNode head = new Solution().insertionSortList(node);
		while(head!=null) {
			DLogger.info("{}", head.val);
			head = head.next;
		}
		
	}

	static class Solution {
	    public ListNode insertionSortList(ListNode head) {
	        ListNode iter = head;
	        ListNode temp = head;
	        while(temp!=null) {
	        	while(iter!=null && iter.val<temp.val) {
	        		iter = iter.next;
	        	}
	        	if(iter!=null) {
		        	int tval = temp.val;
		        	temp.val = iter.val;
		        	iter.val = tval;
	        	}
	        	temp = temp.next;
	        }
	        return head;
	    }
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return   val + " -> " + next;
		}
		
	}

}
