package com.driver;

import java.util.ArrayList;
import java.util.List;

import com.logger.DLogger;

public class SpiralOrder {
	public static void main(String[] args) {
		DLogger.info("{}", new SpiralOrder().new Solution().spiralOrder(new int[][] 
		{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
		}));

		DLogger.info("{}", new SpiralOrder().new Solution().spiralOrder(new int[][] 
		{
			{1,2,3},
			{5,6,7},
			{9,10,11},
		}));
		
		DLogger.info("{}", new SpiralOrder().new Solution().spiralOrder(new int[][] 
		{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16},
		}));
	}
	class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        int top = 0;
	        int left = 0;
	        int bottom = matrix.length-1;
	        int right = matrix[0].length-1;
	        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
	        int dirIndex = 0;
	        int x=0;
	        int y=-1;
	        List<Integer> result = new ArrayList<>();
	        while(true) {
	        	if(x+dirs[dirIndex][0]>bottom) {
	        		dirIndex = (dirIndex+1)%4;
	        		right--;
	        	}
	        	else if(x+dirs[dirIndex][0]<top) {
	        		dirIndex = (dirIndex+1)%4;
	        		left++;
	        	}
	        	else if(y+dirs[dirIndex][1]>right) {
	        		dirIndex = (dirIndex+1)%4;
	        		top++;
	        	}
	        	else if(y+dirs[dirIndex][1]<left) {
	        		dirIndex = (dirIndex+1)%4;
	        		bottom--;
	        	}
	        	x+=dirs[dirIndex][0];
	        	y+=dirs[dirIndex][1];
	        	if(top<=bottom && left<=right) {
	        		result.add(matrix[x][y]);
	        	}
	        	else break;
	        }
	        return result;
	    }
	}
}
