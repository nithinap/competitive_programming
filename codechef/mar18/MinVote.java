package lc.mar18;

import java.util.Arrays;
import java.util.Scanner;

public class MinVote {

	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			int[] s = new int[n];
			for (int i = 0; i < n; i++) {
				s[i] = sc.nextInt();
			}

			int[] count = new int[n];
/*			Arrays.fill(count, 2);
			count[0] = 1;
			count[n - 1] = 1;*/
/*
			boolean[][] votes = new boolean[n][n]; // all votes[i][i] = false -- no vote to self

			for (int i = 0; i < n; i++) { // vote for adjacent folks is true
				if (i - 1 >= 0)
					votes[i][i - 1] = true;
				if (i + 1 < n)
					votes[i][i + 1] = true;
			}
*/
			// calc pref sum
			long[] psum = new long[n];
			psum[0] = s[0];
			for (int i = 1; i < n; i++) {
				psum[i] = psum[i - 1] + s[i];
				// System.out.print(psum[i]+" ");
			}
			// System.out.println();


			for (int i = 0; i < n; i++) {
/*				for (int j = i + 2; j < n; j++) {
					if (!votes[i][j]) {
						long tsum = psum[j] - psum[i] - s[j];
						if (s[i] >= tsum) {
							// System.out.println((i+1) + " votes for "+ (j+1) );
							votes[i][j] = true;
							// count[j]++; }
							if (s[j] >= tsum) {
								votes[j][i] = true;
								// count[i]++;
							}
						}
					}
				}*/
				
				for (int j = i - 1; j >= 0; j--) {
					if (psum[i] - psum[j] - s[i] <= s[i])
						count[j]++;
				}
				
				for (int j = i + 1;  j < n; j++) {
					if (psum[j] - psum[i] - s[j] <= s[i]) 
						count[j]++;
				}
				
			}

			// print_2darr(votes, n, n);
			/*
			 * for (int i = 0; i < n; i++) { for (int j = 0; j < n; j++) { if (votes[i][j])
			 * count[j]++; } }
			 */

			for (int i = 0; i < n; i++) {
				System.out.print(count[i] + " ");
			}

			System.out.println();
		}

		sc.close();
	}

	private static void print_2darr(boolean[][] votes, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print((votes[i][j] ? "T" : "F") + " ");
			System.out.println();
		}
	}
}
