package com.driver;

public class RotateList {

	public class ListNode {
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
	}

	class Solution {
		public ListNode rotateRight(ListNode head, int k) {
			if (head == null || head.next == null)
				return head;
			ListNode temp = head;
			int n = 0;
			while (temp.next != null) {
				temp = temp.next;
				n++;
			}
			n++;
			k %= n;
			temp.next = head;
			int headInd = n - k;
			temp = head;
			while (headInd-- > 1) {
				temp = temp.next;
			}
			head = temp.next;
			temp.next = null;

			return head;

		}
	}
}
