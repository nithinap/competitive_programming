package lc.may18;

import java.util.Arrays;
import java.util.Scanner;

public class DibFib {
	private static final int MOD = 1000000007;
	static long[] fib = new long[65];
	static long[][] fd = new long[60][4];
	
	public static void main(String[] args) {
		int t, m, n;
		Scanner sc = new Scanner(System.in);
		
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i <= 64; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		
		for (long[] row : fd)
			Arrays.fill(row, -1);
		
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
					if (n > 2) {
						// res += ((ai * f[n - 3]) % MOD + (bj * f[n - 2]) % MOD) % MOD;
						// need to optimize here
						//res += ((ai*getFib(n-3, 0)) %MOD + (bj * getFib(n-2, 0)) %MOD) % MOD;
					} else if (n == 1)
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

	private static long getFib(int n, int d) {
		if (n <= 60) {
			return fib[n] % MOD;
		}
		
		int val = n%4;
		if (fd[d][val] != -1) {
			return fd[d][val];
		}
		
		int k = n >> 1;
		long a,b,c;
		
		a = getFib(k, d+1);
		b = getFib(k-1, d+1);
		
		if (n%2 == 0) {
			fd[d][val] =(modmul(a, a) + modmul(b, b));
		} else {
			c = getFib(k+1, d+1);
			fd[d][val] = (modmul(a, c) + modmul(b, a));
		}
		if (fd[d][val] >= MOD)
			fd[d][val] -= MOD;
		
		return fd[d][val];
	}

	private static long modmul(long a, long b) {
		long res = a;
		res *= b;
		long c = (long)res/MOD;
		a = a*b;
		a -= c * MOD;
		a %= MOD;
		if (a < 0) a+= MOD;
		return a;
	}
}
