package com.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.logger.DLogger;

public class PermuteUnique {
	public static void main(String[] args) {
		Solution solution = new PermuteUnique().new Solution();
		DLogger.info("{}", solution.permuteUnique(new int[] {1,2}).size());
		DLogger.info("{}", solution.permuteUnique(new int[] {1,2,3}).size());
		DLogger.info("{}", solution.permuteUnique(new int[] {-1,2,-1,2,1,-1,2,1}).size());
	}
	class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        return permute(Arrays.stream(nums).boxed().toList());
	    }

		private List<List<Integer>> permute(List<Integer> list) {
			list = List.copyOf(list);
			int n = list.size();
			if(n==0) return new ArrayList<>();
			if(n==1) return List.of(List.copyOf(list));
			List<List<Integer>> result = new ArrayList<>();
			int prev = 101;
			for(int i=0;i<n;i++) {
				int removedEl = list.remove(i);
				if(removedEl==prev) continue;
				prev = removedEl;
				List<List<Integer>> remainPermute = permute(list);
				for(List<Integer> arr : remainPermute) {
					for(int j=1;j<n;j++) {
						result.add(add(removedEl, arr, j));
					}
				}
			}
			return new ArrayList<>();
		}

		private List<Integer> add(int removedEl, List<Integer> arr, int j) {
			List<Integer> copy = List.copyOf(arr);
			copy.add(j, removedEl);
			return copy;
		}

	}
}
