package com.driver;

class ListNode {
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
		return val + "->" + next;
	}
}
public class ReorderLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		new ReorderLinkedList().new Solution().reorderList(head);
		System.out.println(head);
	}

	class Solution {
		public void reorderList(ListNode head) {
			ListNode list1 = head;
			ListNode list2 = head.next;
			while(list2!=null && list2.next!=null) {
				list1 = list1.next;
				list2 = list2.next.next;
			}
			ListNode head2 = list1.next;
			list1.next = null;
			head2 = reverseList(head2);
			list1 = head;
			list2 = head2;
			while(list1!=null) {
				ListNode temp = list1.next;
				list1.next = list2;
				if(list2==null) break;
				ListNode temp2 = list2.next;
				list2.next = temp;
				list2 = temp2;
				list1 = temp;
			}
		}
		
		public ListNode reverseList(ListNode head) {
			if(head==null) return null;
			ListNode hanging = head.next;
			ListNode current = head;
			ListNode prev = null;
			while (hanging != null) {
				current.next = prev;
				prev = current;
				current = hanging;
				hanging = hanging.next;
			}
			current.next = prev;
			return current;
		}
	}
}
