package com.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.logger.DLogger;

public class Permute {
	public static void main(String[] args) {
		Solution solution = new Permute().new Solution();
		DLogger.info("{}", solution.permuteUnique(new int[] {1,2}).size());
		DLogger.info("{}", solution.permuteUnique(new int[] {1,2,3}).size());
		DLogger.info("{}", solution.permuteUnique(new int[] {-1,2,-1,2,1,-1,2,1}).size());
	}
	class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        permute(nums, 0, result);
	        return result;
	    }

		private void add(List<List<Integer>> result, int[] ele) {
			for(List<Integer> el : result) {
	        	int n = ele.length;
	        	boolean matched = true;
	        	for(int i=0;i<n;i++) {
	        		if(!el.get(i).equals(ele[i])) {
	        			matched = false;
	        			break;
	        		}
	        	}
	        	if(matched) return;
	        }
			result.add(Arrays.stream(ele).boxed().toList());
		}

		private void permute(int[] nums, int i, List<List<Integer>> result) {
			if(i==nums.length) {
				add(result, nums);
				return;
			}
			for(int j=0;j<nums.length;j++) {
				if(nums[i]==nums[j]) {
					add(result, nums);
					continue;
				}
				swap(nums, i, j);
				permute(nums, i+1, result);
				swap(nums, i, j);
			}
		}

		private void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}
