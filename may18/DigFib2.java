package lc.may18;

import java.util.Scanner;

public class DigFib2 {
	private static final int MOD = 1000000007;

	public static void main(String[] args) {
		int t, m, n;
		Scanner sc = new Scanner(System.in);
		long[] f = new long[100000];
		
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < 100000; i++) {
			f[i] = (f[i - 1] + f[i - 2]) % MOD;
		}
		
		t = sc.nextInt();
		while (t-- > 0) {
			m = sc.nextInt();
			n = sc.nextInt();

			long[] a = new long[m];
			long[] b = new long[m];
			for (int i = 0; i < m; i++) {
				a[i] = sc.nextInt();
			}

			for (int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}

			long res = 0;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					long ai = a[i];
					long bj = b[j];
					if (n > 2)
						//res += ((ai * f[n - 3]) % MOD + (bj * f[n - 2]) % MOD) % MOD;
						res += modmul(ai, f[n-3]) + modmul(bj, f[n-2]);
					else if (n == 1)
						res += ai;
					else if (n == 2)
						res += bj;
						
					res %= MOD;
				}
			}

			System.out.println(res);
		}

		sc.close();
	}

	private static long modmul(long a, long b) {
		long res = a;
		res *= b;
		long c = res/MOD;
		a = a*b;
		a -= c * MOD;
		a %= MOD;
		if (a < 0) a+= MOD;
		return a;
	}
}