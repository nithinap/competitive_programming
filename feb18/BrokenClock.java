package lc.feb18;

import java.util.Scanner;

public class BrokenClock {
	public static final long MOD = 1000000007;

	static long modulo(long a, long b) {
		long r = a % b;
		if (((b > 0) && (r < 0)) || ((b < 0) && (r > 0)))
			r += b;
		return r;
	}

	public static long gcdExtended(long a, long b, long x, long y) {
		if (a == 0) {
			x = 0;
			y = 1;
			return b;
		}

		long x1 = 1, y1 = 1;
		long gcd = gcdExtended(b % a, a, x1, y1);
		x = y1 - (b / a) * x1;
		y = x1;

		return gcd;
	}

	private static long modInv(long a, long m) {
		long x = 1, y = 1;
		a = modulo(a, m);
		long g = gcdExtended(a, m, x, y);
		if (g != 1)
			System.out.println("No inverse");
		else {
			long res = (x % m + m) % m;
			return res;
		}
		return 0;
	}

	private static void solve(long l, long d, long t) {
		float angle = (float) (Math.acos(d / (double) l) * 180.0D / Math.PI); // in deg
		long[] tp = new long[1000006];
		long[] tq = new long[1000006];

		tp[0] = l;
		tp[1] = d;
		tq[0] = tq[1] = 1;

		int i;
		for (i = 2; (angle * i) < 360; i++) {
			boolean neg = false;
			float p = (float) Math.cos(angle * i * Math.PI / 180);
			if (p < 0) {
				neg = true;
				p *= -1;
			}

			String num = String.valueOf(Math.abs(p));
			long tmp = (long)Math.abs(p);
			long q;
//			if (Math.abs(p) - tmp > 0)
				q = num.length() - num.indexOf('.') - 1;
//			else 
//				q = 1;
			
			q = (long) Math.pow(10, q);
//			System.out.println(num + " === " + q);

			long val = (l * (long) (p * q) % MOD) % MOD;
			if (val < 0) {
				neg = true;
				val *= -1;
			}

			long den = gcdExtended(val, q, 1, 1);
			tp[i] = val / den;
			tq[i] = q / den;

			if (neg) {
				tq[i] *= -1;
				neg = false;
			}
		}
		int newtime = (int) (t % (i - 1));
		long res = modInv(tq[newtime], MOD);
//		System.out.println("newtime: " + newtime + "=== res: " + res);
		long mul = (tp[newtime] * res) % MOD;
		System.out.println(mul);
	}

	public static void main(String[] args) {
		int T;
		long d, l, t;

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		while (T-- > 0) {
			l = sc.nextLong();
			d = sc.nextLong();
			t = sc.nextLong();

			solve(l, d, t);

		}

		sc.close();
	}
}
