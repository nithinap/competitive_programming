package lc.jan18;

import java.util.Scanner;

public class Partition {
	void solve(int n, int x) {

		int[] partition = new int[n + 1];
		long sum = n * (n + 1) / 2;
		int p = 0, k = 0;

		partition[x] = 2;
		sum -= x;

		if (sum % 2 != 0 || n == 1 || n == 2) {
			System.out.println("impossible");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (i != x) {
				k++;
				if (k % 4 == 1 || k % 4 == 0) {
					partition[i] = 1;
					p += i;
				} else {
					partition[i] = 0;
				}
			}
		}
		
		long q = Math.abs(p - sum / 2);
		long s = q;
		if (p < sum / 2) {/*
			while (s != 0 && q > 0) {
				for (int i = 1; i <= n; i++) {
					if (partition[i + q] == 0 && partition[i] == 1 && (i + q) <= n && s >= q && s != 0) {
						s -= q;
						partition[i] = 0;
						partition[i + q] = 1;
					}
				}
				q--;
			}
			if (s == 0) {
				for (int i = 1; i <= n; i++)
					System.out.print(partition[i]);
				System.out.println();
			} else
				System.out.println("impossible");
		*/} else if (p > sum / 2) {/*
			while (s != 0 && q > 0) {
				for (int i = 1; i <= n; i++) {
					if (partition[i + q] == 1 && partition[i] == 0 && (i + q) <= n && s >= q && s != 0) {
						s -= q;
						partition[i] = 1;
						partition[i + q] = 0;
					}
				}
				q--;
			}
			if (s == 0) {
				for (int i = 1; i <= n; i++)
					System.out.print(partition[i]);
				System.out.println();
			} else
				System.out.println("impossible");
		*/} else {
			for (int i = 1; i <= n; i++)
				System.out.print(partition[i]);
			System.out.println();

		}
	}

	public static void main(String[] args) {

		int t;
		int x, n;

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			long i, j, p = 0, k = 0;
			x = sc.nextInt();
			n = sc.nextInt();

		}
	}
}