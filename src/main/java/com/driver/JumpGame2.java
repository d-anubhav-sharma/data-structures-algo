package com.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.logger.DLogger;

public class JumpGame2 {
	
	public static void main(String[] args) {
		Solution solution = new JumpGame2().new Solution();
		DLogger.info("{}", List.of(
			solution.jump(new int[] {2,3,1,1,4}),
			solution.jump(new int[] {2,3,0,1,4}),
			solution.jump(new int[] {0}),
			solution.jump(new int[] {1,2,3})
		));
	}
	
	class GNode{
		int val;
		List<Integer> children = new ArrayList<>();
		
		public GNode(int val) {
			super();
			this.val = val;
		}
		
	}
	
	class Solution {
	    public int jump(int[] nums) {
	    	int n = nums.length;
	        if(n==1) return 0;
	    	int[] dp = new int[n+1];
	    	Arrays.fill(dp, Integer.MAX_VALUE);
	    	dp[0] = 0;
	    	for(int i=1;i<=n;i++) {
	    		int maxJump = nums[i-1];
	    		for(int j=i;j<i+maxJump && j<=n;j++) {
                    int val = Math.min(dp[j], dp[i-1]+1);
                    if(j==n-1) return val;
	    			dp[j] = val;
	    		}
	    	}
	    	return dp[n-1];
	    	
	    }
	    
	}
}
