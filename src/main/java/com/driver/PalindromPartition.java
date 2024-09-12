package com.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PalindromPartition {
	public static void main(String[] args) {
		System.out.println(new PalindromPartition().new Solution().partition("a"));
	}
	
	class Solution {
	    public List<List<String>> partition(String s) {
	    	Map<Integer, List<Integer>> map = new TreeMap<>();
	    	List<List<String>> result = new ArrayList<>();
	    	int n = s.length();
	        for(int i=0;i<n;i++) {
	        	for(int j=i+1;j<=n;j++) {
	        		if(isPalin(s.substring(i, j))) {
	        			map
		        			.computeIfAbsent(i, ind -> new ArrayList<>())
		        			.add(j-1);
	        		}
	        		
	        	}
	        }
	        addStringToList(map, s, result, 0, "");
	        return result;
	    }

		private void addStringToList(Map<Integer, List<Integer>> map, String s, List<List<String>> result, int i, String node) {
			if(i>=s.length()) {
				System.out.println(node);
				result.add(Arrays.asList(node.split(",")));
				return;
			}
			for(int x: map.get(i)) {
				addStringToList(map, s, result, x+1, (!node.isEmpty()?node+",":"")+s.substring(i,x+1));
			}
		}

		private boolean isPalin(String string) {
			int i = 0;
			int j = string.length()-1;
			if(j<1) return true;
			while(i<=j) if(string.charAt(i++)!=string.charAt(j--)) return false;
			return true;
		}
	    
	}
}
