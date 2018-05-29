package lc.jan18;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaxScore {
	private static Long maxScore(Long[][] a, int n) {
		Long sum = Collections.max(Arrays.asList(a[n-1]));
		Long prev_max = sum;
		
		for (int i = n - 2; i >= 0; i--) {
			// find max element less than prev_max in a[i][]
			Long closest_max = Long.MIN_VALUE;
			for (int j=0; j<n; j++) {
				if (a[i][j] > closest_max && a[i][j] < prev_max) {
					closest_max = a[i][j];
				}
			}
			if (closest_max == Long.MIN_VALUE) {
				return new Long(-1);
			}
			sum += closest_max;
			prev_max = closest_max;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			Long[][] a = new Long[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextLong();
				}
			}

			System.out.println(maxScore(a, n));
		}
		
		sc.close();
	}


}
