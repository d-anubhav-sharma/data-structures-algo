package com.driver;

import java.util.ArrayList;
import java.util.List;

import com.logger.DLogger;

public class PermutationSequence {

	public static void main(String[] args) {
		Solution solution = new PermutationSequence().new Solution();
		DLogger.info("{}", solution.getPermutation(3, 3).equals("213"));
		DLogger.info("{}", solution.getPermutation(4, 9).equals("2314"));
		DLogger.info("{}", solution.getPermutation(9, 10000).equals("139846572"));
		DLogger.info("{}", solution.getPermutation(3, 3));
		DLogger.info("{}", solution.getPermutation(3, 3));
	}

	class Solution {
		private static final int[] fact = new int[] { 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

		public String getPermutation(int n, int k) {
			k--;
			StringBuilder result = new StringBuilder();
			List<Integer> nums = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				nums.add(i);
			}
			int ind = n - 1;
			while (ind-- > 0) {
				result.append(nums.remove(k / fact[ind]));
				k = k % fact[ind];
			}
			for(int x: nums) result.append(x);
			return result.toString();
		}
	}
}
