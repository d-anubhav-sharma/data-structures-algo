package com.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NBaseDates {

	class Result {
	    public static int solve(List<List<Integer>> dates) {
	    	Map<Integer, Integer> map = new HashMap<>();
	    	for(List<Integer> date : dates) {
	    		addDateToMap(date, map);
	    	}
	    	int sum = 0;
	    	for(int x : map.values()) {
	    		if(x>1) {
	    			sum+=(x*(x-1))/2;
	    		}
	    	}
	    	return sum;
	    }

		private static void addDateToMap(List<Integer> date, Map<Integer, Integer> map) {
			int base = date.get(0);
			if(base==1) return;
			int value = date.get(1);
			int digit;
			int base10value = 0;
			int place = 0;
			while(value>0) {
				digit = value%10;
				if(digit>=base) return;
				base10value += digit*Math.pow(base, place++);
				value /=10;
			}
			map.compute(base10value, (k, v) -> v==null?1:v+1);
		}

	}
}
