package hackerearth.hiringchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Query implements Comparator<Query> {
	int k;
	int ind;

	@Override
	public int compare(Query o1, Query o2) {
		return o1.k - o2.k;
	}
}

public class BobForest {
	public static void main(String[] args) throws IOException {
		int n, m;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}

		// fill dp[i][j] with max size of square submatrix with bottom right corner as
		// (i, j)
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 || j == 0) {
					if (str[i].charAt(j) == '*')
						dp[i][j] = 1;
				} else {
					if (str[i - 1].charAt(j) == '*' && str[i].charAt(j - 1) == '*' && str[i - 1].charAt(j - 1) == '*') {
						if (str[i].charAt(j) == '*')
							dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
					} else if (str[i].charAt(j) == '*')
						dp[i][j] = 1;
				}
			}
		}

		int[] freq = new int[1001];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				freq[dp[i][j]]++;
			}
		}
		
		long[] ssum = new long[1001];
		ssum[1000] = freq[1000];
		for (int i=999; i > 0; i--) {
			ssum[i] = ssum[i+1] + freq[i];
		}
		
		long[] psum = new long[1001];
		psum[1] = ssum[1];
		for (int i=2; i<1001; i++) {
			psum[i] = psum[i-1] + ssum[i];
		}
		
		// queries
		int q = Integer.parseInt(br.readLine());
		int k;
		for (int i=0; i<q; i++) {
			k = Integer.parseInt(br.readLine());
			System.out.println(psum[k]);
		}

	}
}
