package com.driver;

import java.util.Arrays;

public class PalindromPartition2 {
	public static void main(String[] args) {
		System.out.println(new PalindromPartition2().new Solution().minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
	}
	
	class Solution {
		public int minCut(String s) {
			int n = s.length();
			boolean[][] isPalin = new boolean[n][n];
			Arrays.fill(isPalin, true);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					
				}
			}
			return 0;
	    }

	}
}
