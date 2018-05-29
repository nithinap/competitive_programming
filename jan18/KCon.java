package lc.jan18;

import java.util.Scanner;

public class KCon {

	private static long kadane(int[] a, int n) {
		long max_so_far = a[0];
		long cur_max = a[0];

		// int i = 0;
		// for (long j = 1; j < n; j++) {
		for (int i = 1; i < n; i++) {
			cur_max = Math.max(a[i], cur_max + a[i]);
			max_so_far = Math.max(max_so_far, cur_max);
		}

		return max_so_far;
	}

	public static void main(String[] args) {
		int t, n, k;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			int[] a = new int[n];
			int[] a2 = new int[2 * n];
			long sum = 0;

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				sum += a[i];
				a2[i] = a[i];
				a2[n + i] = a[i];
			}

			long max_kadane = kadane(a, n);
			long max_kadane2 = kadane(a2, 2 * n);

			if (k > 1) {
				System.out.println(max_kadane2 + (k - 2) * Math.max(sum, 0));
			} else {
				System.out.println(max_kadane);
			}

		}

		sc.close();
	}
}
