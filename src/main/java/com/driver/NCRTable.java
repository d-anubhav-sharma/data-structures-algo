package com.driver;

import java.util.ArrayList;
import java.util.List;

import com.logger.DLogger;

public class NCRTable {
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			DLogger.info("{}.\t{}", i, (Result.solve(i)));
		}
	}
	
	class Result {
	    public static List<Integer> solve(int n) {
	    	List<Integer> result = new ArrayList<>();
	    	result.add(1);
	    	result.add(1);
	    	if(n==0) return List.of(1);
	    	if(n==1) return result;
	    	for(int i=1;i<n;i++) {
	    		int k = result.size();
	    		for(int j=k-1;j>0;j--) {
	    			result.set(j, (result.get(j)+result.get(j-1))%1000000000);
	    		}
	    		result.add(1);
	    	}
	    	return result;
	    }
	}
}
