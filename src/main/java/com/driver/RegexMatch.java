package com.driver;

import com.logger.DLogger;

public class RegexMatch {
	public static void main(String[] args) {
		Solution solution = new RegexMatch().new Solution();
		DLogger.info("{} {} {} {} {} {} {} {} {} {} ", 
				solution.isMatch("", ""),
				solution.isMatch("ab", "ab"),
				solution.isMatch("aa", "*"),
				solution.isMatch("", "*"),
				solution.isMatch("axb", "a?b"),
				solution.isMatch("axb", "a*b"),
				solution.isMatch("axyzb", "a*b"),
				solution.isMatch("ab", "a*b"),
				!solution.isMatch("a", "a*b"),
				!solution.isMatch("axyzb", "a?b")
		);
	}
	class Solution {
	    public boolean isMatch(String s, String p) {
	    	int sn = s.length();
	    	int pn = p.length();
	    	boolean[][] sp = new boolean[sn+1][pn+1];
	    	sp[0][0] = true;
	    	for(int i=0;i<pn;i++) {
	    		if(p.charAt(i)=='*') {
	    			sp[0][i+1] = sp[0][i];
	    		}
	    	}
	    	for(int i=0;i<sn;i++) {
	    		char sc = s.charAt(i);
	    		for(int j=0;j<pn;j++) {
	    			char pc = p.charAt(j);
	    			if(pc=='*') {
	    				sp[i+1][j+1] = sp[i][j+1] || sp[i+1][j];
	    			}
	    			else if(pc==sc || pc=='?') {
	    				sp[i+1][j+1] = sp[i][j];
	    			}
	    		}
	    	}
		    return sp[sn][pn];
	    }
	}
}
