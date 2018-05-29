package hackerearth.july.circuits;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeCells {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		sc.close();

		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
				101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
				211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331,
				337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397 };
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < primes.length; i++)
			set.add(primes[i]);

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum, left, right, up, down;
				up = (i > 0) ? m[i - 1][j] : 0;
				down = (i < n - 1) ? m[i + 1][j] : 0;
				left = (j > 0) ? m[i][j - 1] : 0;
				right = (j < n - 1) ? m[i][j + 1] : 0;

				sum = up + down + right + left;
				if (set.contains(sum)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
