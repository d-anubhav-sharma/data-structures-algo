package com.driver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.logger.DLogger;

public class CombinationSum {
	
	public static void main(String[] args) {
		DLogger.info("{}\n{}\n{}", 
			new CombinationSum().new Solution().combinationSum(new int[] {2,3,6,7}, 7),
			new CombinationSum().new Solution().combinationSum(new int[] {2,3,5}, 8),
			new CombinationSum().new Solution().combinationSum(new int[] {2}, 1)
		);
	}
	
	class SumData{
		List<SumData> children;
		int rem;
		int val;
		
		public SumData(List<SumData> children, int rem, int val) {
			super();
			this.children = children;
			this.rem = rem;
			this.val = val;
		}

		@Override
		public String toString() {
			return String.format("{val: \"%s\", rem: \"%s\", children: %s}", val, rem, children);
		}
		
		
	}
	
	class Solution{
		
		class Data {
			List<Integer> result = new ArrayList<>();

			Data(List<Integer> list){
				this.result = list;
			}
			
			@Override
			public int hashCode() {
				return 0;
			}
			
			@Override
			public boolean equals(Object target) {
				if(target instanceof Data other) {
					if(this.result.size()!=other.result.size()) return false;
					int n = this.result.size();
					for(int i=0;i<n;i++) {
						if(this.result.get(i)!=other.result.get(i)) return false;
					}
					return true;
				}
				return false;
			}

		}
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        Arrays.sort(candidates);
	        Set<Data> result = new HashSet<>();
	        Deque<Integer> stack = new ArrayDeque<>();
	        traverse(stack, candidates, result, target);
	        return result.stream().map(e -> e.result).toList();
	    }

		private void traverse(Deque<Integer> stack, int[] candidates, Set<Data> result, int rem) {
			if(rem==0) {
				List<Integer> list = new ArrayList<>(stack);
				list.sort((i,j)->i-j);
				result.add(new Data(list));
				return;
			}
			for(int x : candidates) {
				if(x<=rem) {
					stack.push(x);
					traverse(stack, candidates, result, rem-x);
					stack.pop();
				}
			}
		}
	}
}
