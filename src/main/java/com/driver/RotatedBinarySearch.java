package com.driver;

import static org.assertj.core.api.Assertions.assertThat;

public class RotatedBinarySearch {
	
	public static void main(String[] args) {
		Solution solution = new RotatedBinarySearch().new Solution();
		int[] result = {
				solution.search(new int[] {4,5,6,7,0,1,2}, 0),
				solution.search(new int[] {4,5,6,7,0,1,2}, 3),
				solution.search(new int[] {1}, 0)
		};
		assertThat(result).containsExactly(4,-1,-1);
	}
	
	class Solution {
	    public int search(int[] nums, int target) {
	        return search(nums, target, 0, nums.length-1);
	    }

		private int search(int[] nums, int target, int start, int end) {
			if(start+1>=end) {
				if(nums[start]==target) return start;
				if(nums[end]==target) return end;
				return -1;
			}
			int mid = start + (end-start)/2;
			if(nums[mid]==target) return mid;
			int index = -1;
			if(nums[mid]<nums[start]) {
				// left is broken
				if(nums[mid]<target) {
					index = search(nums, target, mid+1, end);
				}
				if(index==-1) {
					index = search(nums, target, start, mid-1);
				}
				return index;
			}
			else if(nums[mid]>nums[end]) {
				// right is broken
				if(nums[mid]>target) {
					index = search(nums, target, start, mid-1);
				}
				if(index==-1) {
					index = search(nums, target, mid+1, end);
				}
				return index;
			}
			else {
				// nothing is broken
				if(nums[mid]>target) return search(nums, target, start, mid-1);
				else return search(nums, target, mid+1, end);
			}
		}
	}
}
