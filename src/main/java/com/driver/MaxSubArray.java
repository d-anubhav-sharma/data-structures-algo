package com.driver;

public class MaxSubArray {
	public static void main(String[] args) {
		System.out.println(new MaxSubArray().new Solution().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));;
	}
	class Solution {
	    public int maxSubArray(int[] nums) {
	    	int n = nums.length;
	    	if(n==0) {
	    		return 0;
	    	}
	    	if(n==1) {
	    		return nums[0];
	    	}
	        int left = 1;
	        int curr = nums[0];
	        int max = nums[0];
	        while(left<n) {
	        	curr += nums[left];
	        	if(curr<nums[left]) curr = nums[left];
	        	max = Math.max(max, curr);
	        	left++;
	        }
	        return max;
	    }
	}
}
