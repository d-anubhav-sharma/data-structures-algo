package com.driver;

public class SpiralMatrix2 {
	class Solution {
		public int[][] generateMatrix(int n) {
			int[][] matrix = new int[n][n];
			int top = 0;
			int left = 0;
			int bottom = matrix.length - 1;
			int right = matrix[0].length - 1;
			int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
			int dirIndex = 0;
			int x = 0;
			int y = -1;
			int index = 1;
			while (true) {
				if (x + dirs[dirIndex][0] > bottom) {
					dirIndex = (dirIndex + 1) % 4;
					right--;
				} else if (x + dirs[dirIndex][0] < top) {
					dirIndex = (dirIndex + 1) % 4;
					left++;
				} else if (y + dirs[dirIndex][1] > right) {
					dirIndex = (dirIndex + 1) % 4;
					top++;
				} else if (y + dirs[dirIndex][1] < left) {
					dirIndex = (dirIndex + 1) % 4;
					bottom--;
				}
				x += dirs[dirIndex][0];
				y += dirs[dirIndex][1];
				if (top <= bottom && left <= right) {
					matrix[x][y] = index * index;
					index++;
				} else
					break;
			}
			return matrix;
		}
	}
}
