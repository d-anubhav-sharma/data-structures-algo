package com.driver;

import com.logger.DLogger;

public class MathSqrt {
	public static void main(String[] args) {
		Solution solution = new MathSqrt().new Solution();
		for(int i=0;i<100;i++) {
			DLogger.info("{} -> {}", i, solution.mySqrt(i));
		}
	}
	class Solution {
	    public int mySqrt(int x) {
            if(x==1||x==0) return x; 
	        return (int)search(x,0,x/2);
	    }

		private long search(long x, long start, long end) {
			long mid = start + (end-start)/2;
			long a = mid*mid;
			long b = (mid+1)*(mid+1);
			if(end<=start+1) {
				if(end*end>x) return start;
				return end;
			}
			if(a<=x && b>x) return mid;
			if(a<x) {
				return search(x, mid, end);
			}
			return search(x, start, mid);
		}
	}
}
