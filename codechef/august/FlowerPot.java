package lc.august;

import java.util.Arrays;
import java.util.Scanner;

public class FlowerPot {

	private static void minCost(int[] a, int n, int b, int c) {
		int pos = c;
		
		long cost = 0;
		boolean[] lit = new boolean[n];
		int[] strength = new int[n];
		
		Arrays.fill(lit, false);
		Arrays.fill(strength, 0);
		
		lit[c] = true;
		int lpos = c-1;
		int rpos = c+1;
		
		//a[pos] - a[lpos]
		
		System.out.println(cost);
	}

	public static void main(String[] args) {
		int t;
		int n, b, c;

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();

			int[] A = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = sc.nextInt();
			}

			minCost(A, n, b, c - 1);
		}

		sc.close();
	}
}
