package com.driver;

public class ImageRotation {
	public static void main(String[] args) {
		new ImageRotation().new Solution().rotate(new int[][] {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		});
	}
	class Solution {
	    public void rotate(int[][] matrix) {
	    	int n = matrix.length;
	    	int top=0;
	    	int left=0;
	    	int right = n-1;
	    	int bottom = n-1;
	        while(top<bottom) {
	        	int mid = (left+right)/2;
	        	for(int i=left;i<=mid;i++) {
	        		int j = n-1-i;
	        		int temp = matrix[top][i];
	        		matrix[top][i] = matrix[j][left];
	        		matrix[j][left] = matrix[bottom][j];
	        		matrix[bottom][j] = matrix[i][right];
	        		matrix[i][right] = temp;
	        	}
	        	top++;
	        	left++;
	        	right--;
	        	bottom--;
	        }
	    }
	}
}
