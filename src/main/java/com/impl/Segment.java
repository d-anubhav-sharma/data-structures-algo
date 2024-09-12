package com.impl;

import java.util.List;

class Segment {
	int left;
	int right;
	long sum;
	Segment leftSegment;
	Segment rightSegment;

	Segment(List<Long> arr, int left, int right) {
		if (arr == null || arr.isEmpty())
			return;

		this.left = left;
		this.right = right;

		if (left == right) {
			this.sum = arr.get(left);
			return;
		}
		int mid = (left + right) / 2;
		leftSegment = new Segment(arr, left, mid);
		rightSegment = new Segment(arr, mid + 1, right);
		this.sum = leftSegment.sum + rightSegment.sum;
	}

	public long lookupSum(int start, int end) {
		
		if (start > right || end < left) {
			return 0L;
		}
		
		if (start <= left && end >= right) {
			return sum;
		}
		
		return (leftSegment != null ? leftSegment.lookupSum(start, end) : 0)
				+ (rightSegment != null ? rightSegment.lookupSum(start, end) : 0);

	}

	@Override
	public String toString() {
		return String.format("""
				{
				"left": %d,
				"right": %d,
				"sum": %d,
				"leftSegment": %s,
				"rightSegment": %s
				}
				                """, left, right, sum, leftSegment, rightSegment);
	}

}
