package com.driver;

public class MinimumClassPathSum {

	public static void main(String[] args) {
		new MinimumClassPathSum().new Solution().minPathSum(null);
	}
	
	class Solution{
	    public int minPathSum(int[][] grid) {
	    	int m = grid.length;
	    	int n = grid[0].length;
	    	int[][] travel = new int[m][n];
	    	travel[0][0] = grid[0][0];
	    	for(int i=1;i<m;i++) {
	    		travel[i][0] = travel[i-1][0]+grid[i][0];
	    	}
	    	for(int j=1;j<n;j++) {
	    		travel[0][j] = travel[0][j-1]+grid[0][j];
	    	}
	    	for(int i=1;i<m;i++) {
	    		for(int j=1;j<n;j++) {
	    			travel[i][j] = Math.min(travel[i-1][j], travel[i][j-1])+grid[i][j];
	    		}
	    	}
	        return travel[m-1][n-1];
	    }
	}
}
