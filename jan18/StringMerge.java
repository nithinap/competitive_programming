package lc.jan18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringMerge {
	static char[] lcs(char[] a, char[] b, int m, int n) {
		int[][] L = new int[m + 1][n + 1];

		// fill L[i][j] with len of LCS(a[0...i-1], b[0...j-1])
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (a[i - 1] == b[j - 1])
					L[i][j] = 1 + L[i - 1][j - 1];
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}

		// L[m][n] has length of LCS now
		int lcsLen = L[m][n];
		char[] lcs = new char[lcsLen + 1];
		
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (a[i - 1] == b[j - 1]) {
				lcs[lcsLen - 1] = a[i - 1];
				i--;
				j--;
				lcsLen--;
			} else if (L[i - 1][j] > L[i][j - 1])
				i--;
			else
				j--;
		}

		return lcs;
	}

	static int func(char[] a, int n) {
		if (n == 0)
			return 0;

		int len = 1;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] != a[i + 1])
				len++;
		}
		return len;
	}

	static int countAdjacent(char[] a, int len) {
		int count = 0;
		for (int i=0; i<len-1; i++) {
			if (a[i] == a[i+1])
				count++;
		}
		return count;
	}
	
	private static char[] shrinkArray(char[] a, int m) {
		StringBuilder sb = new StringBuilder();
		sb.append(a[0]);
		if (m > 1)
		for (int i=1; i<m; i++) {
			if (a[i] != a[i-1])
				sb.append(a[i]);
		}
		return sb.toString().toCharArray();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t, m, n, ans = 0;
		String a, b;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] mn = br.readLine().split(" ");
			m = Integer.parseInt(mn[0]);
			n = Integer.parseInt(mn[1]);
			a = br.readLine();
			b = br.readLine();

			char[] ac = a.toCharArray();
			char[] bc = b.toCharArray();
			
			int adj = 0;
			adj += countAdjacent(ac, m);
			adj += countAdjacent(bc, n);
			
			char[] a2 = shrinkArray(ac, m);
			char[] b2 = shrinkArray(bc, n);
//			System.out.println(a2);
//			System.out.println(b2);
//			System.out.println("adj: "+adj);
			char[] lcs = lcs(a2, b2, a2.length, b2.length);
//			System.out.println("lcs len: "+lcs.length);
//			System.out.println("m: "+m+"| m: "+n);
//			System.out.println(lcs);
//			ans = func(ac, m) + func(bc, n) - func(lcs, lcs.length - 1);
//			System.out.println(ans);
			ans = (m + n) - adj - (lcs.length - 1);
			System.out.println(ans);
		}
	}
}
