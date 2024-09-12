package com.driver;

import java.util.List;

public class SolveComplexMultiply {

	static class Complex {
		long x;
		long y;
		private static long MOD;

		Complex(long x, long y, long mod) {
			this.x = x;
			this.y = y;
			MOD = mod;
		}

		List<Integer> getCofs() {
			return List.of((int) x, (int) y);
		}

		public void square() {
			long a = (((x * x) % MOD - (y * y) % MOD) % MOD);
			long b = ((2 * (x * y) % MOD) % MOD);
			x = a;
			y = b;
		}

		public Complex copy() {
			return new Complex(x, y, MOD);
		}

		public void mul(Complex baseCopy) {
			long a = ((x * baseCopy.x) % MOD - (y * baseCopy.y) % MOD) % MOD;
			long b = ((x * baseCopy.y) % MOD + (y * baseCopy.x) % MOD) % MOD;
			x = a;
			y = b;
		}
	}

	class Result {
		public static List<Integer> solve(int a, int b, long k, int m) {
			return pow(new Complex(a, b, m), k, m);
		}

		private static List<Integer> pow(Complex complex, long exp, int m) {
			Complex result = new Complex(1, 0, m);
			Complex baseCopy = complex.copy();
			while (exp > 0) {
				if ((exp & 1) == 1) {
					result.mul(baseCopy);
				}
				baseCopy.square();
				exp >>= 1;
			}
			return result.getCofs();
		}

	}
}
