package lc.mar18;

import java.util.Arrays;
import java.util.Scanner;

public class MinionEat {

	private static int binSearch(int[] a, int low, int high, int h) {
		// System.out.printf("low: %d; high: %d", low, high);
		// System.out.println();
		int n = a.length;
		if (low >= high || low + 1 == high) {
			return high;
		}

		int mid = low + (high - low) / 2;
		long tmp = 0;

		for (int i = 0; i < n; i++) {
			tmp += Math.ceil((double) a[i] / mid);
		}

		if (tmp <= h) {
			return binSearch(a, low, mid, h);
		} else {
			return binSearch(a, mid, high, h);
		}

	}

	public static void main(String[] args) {
		int t, n, h;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			h = sc.nextInt();

			int[] a = new int[n];
			int max = 0;
			// long[] psum = new long[n];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				if (a[i] > max)
					max = a[i];
			}

			/*
			 * psum[0] = a[0]; for (int i=1; i<n; i++) { psum[i] = psum[i-1] + a[i]; }
			 */

			if (n == h)
				System.out.println(max);
			else {
				// find min K, such that sum [ceil(a[i]/K)] over all i in range(n) <= H
				// Arrays.sort(a);
				int low, high;
				low = 1;
				high = a[n - 1];

				System.out.println(binSearch(a, low, max, h));
				// System.out.println(findK(a, psum, n, h));
			}
		}

		sc.close();
	}

	private static long findK(int[] a, long[] psum, int n, int h) {
		Arrays.sort(a);
		long rem, leftOff = a[n - 1];
		for (int i = n - 1; i >= 0; i--) {
			rem = h - i;
			leftOff = (long) Math.ceil((psum[i] * 1.0) / rem);
			if (leftOff >= a[i - 1]) {
				break;
			}
		}

		return leftOff;
	}
}
