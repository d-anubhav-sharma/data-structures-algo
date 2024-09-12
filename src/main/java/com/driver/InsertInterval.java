package com.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.logger.DLogger;

public class InsertInterval {
	public static void main(String[] args) {
		Solution solution = new InsertInterval().new Solution();
		DLogger.info("{}", Arrays.deepToString(solution.insert(new int[][] { { 1, 5 } }, new int[] { 2, 3 })));
	}

	class Solution {
		public int[][] insert(int[][] intervals, int[] newInterval) {
			int n = intervals.length;
			int[][] newIntervals = new int[n + 1][2];
			System.arraycopy(intervals, 0, newIntervals, 0, n);
			newIntervals[n] = newInterval;
			return merge(newIntervals);
		}

		public int[][] merge(int[][] arr) {
			Arrays.sort(arr, (a, b) -> a[0] - b[0]);
			int n = arr.length;
			List<int[]> narr = new ArrayList<>();
			int i = 0;
			while (++i < n) {
				if (disjoint(arr[i - 1], arr[i])) {
					narr.add(arr[i - 1]);
				} else {
					arr[i][0] = Math.min(arr[i][0], arr[i - 1][0]);
					arr[i][1] = Math.max(arr[i][1], arr[i - 1][1]);
				}
			}
			narr.add(arr[i - 1]);
			n = narr.size();
			int[][] result = new int[n][2];
			for (int j = 0; j < n; j++)
				result[j] = narr.get(j);
			return result;
		}

		private boolean disjoint(int[] xy1, int[] xy2) {
			return Math.max(xy1[0], xy2[0]) > Math.min(xy1[1], xy2[1]);
		}
	}
}
