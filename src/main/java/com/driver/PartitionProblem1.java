package com.driver;

import java.util.ArrayList;
import java.util.List;

public class PartitionProblem1 {
	public static void main(String[] args) {
		System.out.println(Result.solve(List.of(1,2,1,1,1,2,1,3)));;
	}

	class Result {

		public static List<Integer> solve(List<Integer> arr) {
			List<Integer> result = new ArrayList<>();
			int sum = 0;
			int max = 0;
			int total = 0;
			for (int x : arr) {
				max = Math.max(max, x);
				total += x;
			}
			addIfPossible(arr, result, max);
			for(int x: arr) {
				sum += x;
				if(total%sum==0)addIfPossible(arr, result, sum);
			}
			return result;
		}

		private static void addIfPossible(List<Integer> arr, List<Integer> result, int firstPart) {
			int sum = 0;
			for(int x : arr) {
				sum+=x;
				if(sum>firstPart) {
					return;
				}
				if(sum==firstPart) {
					sum = 0;
				}
			}
			if(sum>0) return;
			result.add(firstPart);
		}

	}

}
