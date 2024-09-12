package com.driver;

import com.logger.DLogger;

public class UniquePaths {
	public static void main(String[] args) {
		Solution solution = new UniquePaths().new Solution();
		DLogger.info("{}", solution.uniquePaths(5,5));
	}
	class Solution {
	    public int uniquePaths(int m, int n) {
	        return comb(m-1,n-1);
	    }
	    
	    public int comb(int x, int y) {
	    	long res = 1;
	    	int t = x+y;
	    	for(int z=x+1;z<=t;z++) res *= z;
	    	for(int z=2;z<=y;z++) res /= z;
	    	return (int)res;
	    }
	}
}
