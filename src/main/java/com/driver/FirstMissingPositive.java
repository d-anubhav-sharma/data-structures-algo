package com.driver;

import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {
	public static void main(String[] args) {
		
	}
	class Solution {
	    public int firstMissingPositive(int[] nums) {
	    	Map<Integer, Integer> map = new HashMap<>();
	    	for(int x : nums) {
	    		map.computeIfPresent(x, (key, value) -> value+1);
	    		map.computeIfAbsent(x, key -> 1);
	    	}
	    	int ind=1;
	    	while(map.get(ind++)!=null);
	        return ind;
	    }
	}
}
