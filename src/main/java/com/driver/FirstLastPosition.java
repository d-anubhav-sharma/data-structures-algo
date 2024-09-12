package com.driver;

import java.util.Arrays;

import com.logger.DLogger;

public class FirstLastPosition {
	
	public static void main(String[] args) {
		Solution solution = new FirstLastPosition().new Solution();
		int[][] result = {
				solution.searchRange(new int[]{5,7,7,8,8,10}, 8),
				solution.searchRange(new int[]{5,7,7,8,8,10}, 6),
				solution.searchRange(new int[]{}, 0),
		};
		DLogger.info("{}", Arrays.deepToString(result));
	}
	
	class Solution {
	    public int[] searchRange(int[] nums, int target) {
	    	int n = nums.length;
	    	if(n==0) return new int[] {-1,-1};
	        return new int[] {findLeft(nums, target, 0, n-1),findRight(nums, target, 0, n-1)};
	    }

		private int findLeft(int[] nums, int target, int start, int end) {
			if(start+1>=end) {
				if(nums[start]==target) return start;
				if(nums[end]==target) return end;
				return -1;
			}
			int mid = start + (end-start)/2;
			if(nums[mid]==target) {
				if(nums[mid-1]!=target) return mid;
				return findLeft(nums, target, start, mid-1);
			}
			if(nums[mid]>target) {
				return findLeft(nums, target, start, mid-1);
			}
			return findLeft(nums, target, mid+1, end);
		}

		private int findRight(int[] nums, int target, int start, int end) {
			if(start+1>=end) {
				if(nums[end]==target) return end;
				if(nums[start]==target) return start;
				return -1;
			}
			int mid = start + (end-start)/2;
			if(nums[mid]==target) {
				if(nums[mid+1]!=target) return mid;
				return findRight(nums, target, mid+1, end);
			}
			if(nums[mid]>target) {
				return findRight(nums, target, start, mid-1);
			}
			return findRight(nums, target, mid+1, end);
		}
	}
}
