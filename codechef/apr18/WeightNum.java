package lc.apr18;

import java.util.Scanner;

public class WeightNum {
	public static final int MOD = 1000000007;

	private static Long power(long a, long b) {
		Long result = new Long(1);
		a = a % MOD;
		while (b > 0) {
			if ((b & 1) == 1) { // If power is odd
				result = (result * a) % MOD;
			}

			b = b >> 1; // b = b/2
			a = (a * a) % MOD;
		}

		return result % MOD;
	}

	public static void main(String[] args) {
		int t, w;
		Long n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextLong();
			w = sc.nextInt();
			// w = Math.abs(w);

			// compute 10^(n-2) + (9 - w)

			Long result = new Long(0);
			if (w >= 0 && w < 9) {
				result = power(10, n - 2);
				result = (result * (9 - w)) % MOD;
			} else if (w > -9 && w < 0) {
				result = power(10, n - 2); // as 10 is valid
				result = (result * (9 - Math.abs(w) + 1)) % MOD;
			} else if (w == -9) {
				result = power(10, n - 2) % MOD;
			}
			System.out.println(result);
		}

		sc.close();
	}

}
