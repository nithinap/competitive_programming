package lc.july;

import java.util.Arrays;

public class PrimeSieve {
	public static void main(String[] args) {
		int n = 400;
		boolean[] marked = new boolean[n + 1];
		Arrays.fill(marked, true);

		for (int p = 2; p * p <= n; p++) {
			if (marked[p] == true) {
				for (int i = p * 2; i <= n; i += p) {
					marked[i] = false;
				}
			}
		}

		// print primes
		for (int p = 2; p <= n; p++) {
			if (marked[p] == true)
				System.out.print(p + ",");
		}
	}
}
