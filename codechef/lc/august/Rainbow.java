package lc.august;

import java.util.Scanner;

public class Rainbow {
	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			int[] A = new int[n];

			for (int i = 0; i < n; i++) {
				A[i] = sc.nextInt();
			}
			String res;
			res = isRainbow(A, n) ? "yes" : "no";
			System.out.println(res);

		}
		sc.close();
	}

	public static boolean isRainbow(int[] A, int n) {
		boolean ispal = true;

		for (int i = 0; i < n / 2; i++) {
			if (A[i] != A[n - i - 1]) {
				return false;
			}
		}

		if (A[n / 2] != 7)
			return false;

		// checking increasing from 1 to 7
		int prev = A[0];
		if (prev != 1)
			return false;
		for (int i = 1; i < n / 2; i++) {
			if (A[i] <= 7) {
				if (A[i] == prev + 1) {
					prev = A[i];
				}
			} else {
				return false;
			}
		}

		return true;
	}

}
