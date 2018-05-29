package lc.apr18;

import java.util.Scanner;

public class AvgPair {
	public static void main(String[] args) {

		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			int[] a = new int[n];
			long[] cmap = new long[2001];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				// sum_set.add(2 * a[i]);
				a[i] += 1000;
				cmap[a[i]] += 1;
			}

			// boolean[] map = new boolean[2001];
			long pairs = 0;

			for (int i = 0; i < 2001; i++) {
				for (int j = i; j < 2001; j++) {
					if (cmap[i] > 0 && cmap[j] > 0 && (i + j) % 2 == 0) {

						if (i == j) {
							pairs += (cmap[i] * (cmap[i] - 1)) / 2;
						} else {

							int temp = i + j;
							if (cmap[temp / 2] > 0) {
								pairs += cmap[i] * cmap[j];
							}
						}
					}
				}
			}

			System.out.println(pairs);
		}

		sc.close();
	}
}
