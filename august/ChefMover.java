package lc.august;

import java.util.Scanner;

public class ChefMover {
	public static void main(String[] args) {
		int t, n, d;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			d = sc.nextInt();

			int[] a = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(computeMinMove(a, n, d));

		}
		sc.close();
	}

	private static long computeMinMove(int[] a, int n, int d) {

		long tsum = 0;

		for (int i = 0; i < n; i++) {
			tsum += a[i];
		}

		// System.out.println("m "+tsum%n);
		if (tsum % n != 0)
			return -1;

		long mean = tsum / n, min = 0, tot = 0, subsum;
		int elem;

		for (int i = 0; i < d; i++) {
			subsum = 0;
			elem = 0;

			for (int j = i; j < n; j += d) {
				tot += a[j] - mean;
				min += Math.abs(tot);
				subsum += a[j];
				elem++;
			}

			if (subsum % elem != 0)
				return -1;

		}

		return min;
	}
}
