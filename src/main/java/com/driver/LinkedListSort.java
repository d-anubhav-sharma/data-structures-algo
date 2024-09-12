package com.driver;

import com.logger.DLogger;

public class LinkedListSort {
	
	public static void main(String[] args) {
		
		ListNode node = new ListNode(4, 
				new ListNode(2, 
				new ListNode(1,
				new ListNode(3, null))));
		ListNode head = new Solution().sortList(node);
		while(head!=null) {
			DLogger.info("{}", head.val);
			head = head.next;
		}
		
	}

	static class Solution {
		public ListNode sortList(ListNode head) {
			return mergeSort(head);

		}

		private ListNode mergeSort(ListNode head) {
			if (head == null || head.next == null)
				return head;
			if(head.next.next==null) {
				if(head.val<head.next.val) return head;
				int val = head.val;
				head.val = head.next.val;
				head.next.val = val;
				return head;
			}
			ListNode mid = head;
			ListNode fast = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				mid = mid.next;
			}

			ListNode right = mid.next;
			mid.next = null;

			return merge(mergeSort(head), mergeSort(right));
		}

		private ListNode merge(ListNode left, ListNode right) {
			if(left==null) return right;
			if(right==null) return left;
			ListNode head = new ListNode();
			ListNode temp = head;
			while(left!=null && right!=null) {
				if(left.val<right.val) {
					temp.next = left;
					left = left.next;
				}
				else {
					temp.next = right;
					right = right.next;
				}
				temp = temp.next;
			}
			if(left!=null) temp.next = left;
			if(right!=null) temp.next = right;
			return head.next;
			
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
