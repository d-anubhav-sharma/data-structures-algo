package com.driver;

import java.util.HashMap;
import java.util.Map;

import com.logger.DLogger;

public class MatrixTracing {
	public static void main(String[] args) {
		DLogger.info("{}", pow(2, 1, 10));
	}
	
	private static final long MOD = 1000000007L;
	private static final Map<Long, Long> INVERSE = new HashMap<>();
	
	public static int solve(int n, int m) {
		INVERSE.put(0L, 0L);
		INVERSE.put(1L, 1L);
		INVERSE.put(MOD-1, MOD-1);
		int a = m+n-2;
		int b = Math.max(m-1, n-1);
		long numer = 1;
		long denom = 1;
		for(int i=b+1;i<=a;i++) {
			numer*=i;
			denom*=(i-b);
			numer%=MOD;
			denom%=MOD;
		}
        return (int)((numer*getOrFindInverse(denom))%MOD);
    }
	
	public static long getOrFindInverse(long n) {
		return INVERSE.computeIfAbsent(n, key -> findInverse(key));
	}

	private static long findInverse(long key) {
		return pow(key, MOD-2, MOD);
	}

	private static long pow(long base, long exp, long mod) {
		long result = 1;
        long baseLong = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * baseLong) % mod;
            }
            baseLong = (baseLong * baseLong) % mod;
            exp >>= 1;
        }
        return result;
	}
}
