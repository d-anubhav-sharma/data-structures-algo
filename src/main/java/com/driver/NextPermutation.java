package com.driver;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import com.logger.DLogger;

public class NextPermutation {

	public static void main(String[] args) {
		Solution solution = new NextPermutation().new Solution();
		int[] nums = new int[] { 1, 2, 3 };
		solution.nextPermutation(nums);
		assertThat(nums).containsExactly(1,3,2);

		nums = new int[] { 3, 2, 1 };
		solution.nextPermutation(nums);
		assertThat(nums).containsExactly(1,2,3);

		nums = new int[] { 1, 1, 5 };
		solution.nextPermutation(nums);
		assertThat(nums).containsExactly(1,5,1);

	}

	class Solution {
		public void nextPermutation(int[] nums) {
			int n = nums.length;
			int swapI = n-1;
			int nextHighest = -1;
			while(nextHighest==-1 && swapI>=0) {
				nextHighest = findNextHighest(nums, swapI, n);
				if(nextHighest==-1) swapI--;
			}
			DLogger.info("Swap {} {} ", swapI, nextHighest);
			if(swapI!=-1 && nextHighest!=-1) {
				swap(nums, swapI, nextHighest);
				Arrays.sort(nums, swapI+1, n);
			}
			else Arrays.sort(nums);
		}

		private void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}

		private int findNextHighest(int[] nums, int curr, int n) {
			int low = Integer.MAX_VALUE;
			int lowIndex = -1;
			for(int i=curr+1;i<n;i++) {
				if(nums[i]>nums[curr] && nums[i]<low) {
					low = nums[i];
					lowIndex = i;
				}
			}
			return lowIndex;
		}

	}
}
