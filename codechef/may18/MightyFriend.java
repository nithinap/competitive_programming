package lc.may18;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MightyFriend {

	public static void main(String[] args) {
		int t, n, k;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			int[] motu = new int[(int) Math.ceil((double) n / 2)];
			int[] tomu = new int[n / 2];
			int s_motu = 0, s_tomu = 0;

			int j = 0;
			for (int i = 0; i < n; i += 2) {
				motu[j++] = a[i];
				s_motu += a[i];
			}

			j = 0;
			for (int i = 1; i < n; i += 2) {
				tomu[j++] = a[i];
				s_tomu += a[i];
			}

			isWinPossible(motu, s_motu, tomu, s_tomu, k);

		}

		sc.close();
	}

	private static void isWinPossible(int[] motu, int s_motu, int[] tomu, int s_tomu, int k) {
		boolean res = false;
		if (s_tomu > s_motu) {
			res = true;
		} else if (s_tomu <= s_motu && k == 0) {
			res = false;
		} else {
			Arrays.sort(motu);
			Arrays.sort(tomu);
			int mlen = motu.length;
			int tlen = tomu.length;

			for (int i = 0; (i < k) && (s_motu >= s_tomu) && (i < mlen && i < tlen); i++) {

				int temp = motu[mlen - 1 - i] - tomu[i];
				if (temp < 0) {
					break;
				}
				s_motu -= temp;
				s_tomu += temp;
			}

			if (s_motu < s_tomu)
				res = true;
		}
		
		String result = (res) ? "YES" : "NO";
		System.out.println(result);
	}
}
