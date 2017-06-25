package JunLC17;

import java.util.Scanner;

public class XenBank {
	public static void main(String[] args) {
		int t, u, v;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			u = sc.nextInt();
			v = sc.nextInt();
			// given any (i, j), this lies on line x+y = (i+j)
			System.out.println(compute_start_rank(u + v + 1) + u);
		}
		sc.close();
	}

	/*
	 * Computes starting rank for points on line x + y = n, where n = (u+v)
	 */
	private static long compute_start_rank(long n) {
		/*
		 * long rank = 1; for (int i=1; i<=n; i++) { rank += i; } return rank;
		 */
		return (n * (n - 1))/2+1;
	}
}
