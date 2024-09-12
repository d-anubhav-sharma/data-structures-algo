package com.driver;

import com.logger.DLogger;

public class UniquePaths2 {
	public static void main(String[] args) {
		DLogger.info("{}", new UniquePaths2().new Solution().uniquePathsWithObstacles(new int[5][5]));
	}
	class Solution {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(obstacleGrid[i][j]==1) {
						obstacleGrid[i][j]=-1;
					}
				}
			}
	        for(int i=0;i<m;i++) {
	        	if(obstacleGrid[i][0]==-1) {
	        		break;
	        	}
	        	obstacleGrid[i][0] = 1;
	        }
	        for(int i=0;i<n;i++) {
	        	if(obstacleGrid[0][i]==-1) {
	        		break;
	        	}
	        	obstacleGrid[0][i] = 1;
	        }
	        
	        for(int i=1;i<m;i++) {
	        	for(int j=1;j<n;j++) {
	        		if(obstacleGrid[i][j]!=-1) {
	        			obstacleGrid[i][j] = or(obstacleGrid[i][j-1],0)+or(obstacleGrid[i-1][j],0);
	        		}
	        	}
	        }
	        return or(obstacleGrid[m-1][n-1],0);
	    }

		private int or(int i, int j) {
			if(i==-1) return j;
			return i;
		}
	}
}
