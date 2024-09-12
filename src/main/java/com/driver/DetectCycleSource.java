package com.driver;

import java.util.HashMap;
import java.util.Map;

public class DetectCycleSource {

	public class Solution {
		public ListNode detectCycle(ListNode head) {
			Map<Integer, Integer> map = new HashMap<>();
			while (head != null) {
				if (map.get(head.hashCode()) != null)
					return head;
				map.put(head.hashCode(),1);
				head = head.next;
			}
			return null;
		}
	}
}
