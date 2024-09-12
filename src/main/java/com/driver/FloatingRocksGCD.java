package com.driver;

public class FloatingRocksGCD {
	
	public static void main(String[] args) {
		
	}
	
	class Result {
	    public static int solve(int x1, int y1, int x2, int y2) {
	        int dx = Math.abs(x2-x1);
	        int dy = Math.abs(y2-y1);
	        return gcd(Math.max(dx, dy),Math.min(dx, dy))-1;
	    }

		private static int gcd(int dx, int dy) {
			if(dy==0) return dx;
			return gcd(dy, dx%dy);
		}

	}
}
