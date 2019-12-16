package lc.nov17;

import java.util.Scanner;

public class CLRL {
	private static String solver(int[] a, int n, int r) {
		int lbound = Integer.MIN_VALUE, rbound = Integer.MAX_VALUE;
		if (n == 1 || n == 2) {
			return "YES";
		} else {
			if(a[0] > r && a[1] > r ) {
				if(a[1] > a[0]) {
					return "NO";
				} else {
					rbound = a[1];
				}
			} else if(a[0] < r && a[1] < r){
				if(a[0] > a[1])
					return "NO";
				else
					lbound = a[1];
			} else {
				if(a[0] < r) {
					lbound = a[0];
					rbound = a[1];
				} else {
					lbound = a[1];
					rbound = a[0];
				}
			}
			
			for (int i = 2; i < n; i++) {
				if (r < lbound || r > rbound) { // r outside [lbound, rbound]
					if (r > rbound && a[i] > rbound) {
						lbound = rbound;
						rbound = a[i];
					} else if (r < lbound && a[i] < lbound) {
						rbound = lbound;
						lbound = a[i];
					}
				} else {
					if (a[i] > rbound || a[i] < lbound) { // r inside [lbound,
															// rbound]
						return "NO";
					} else {
						if (a[i] < r)
							lbound = a[i];
						else
							rbound = a[i];
					}
				}
//				System.out.println("lb: " + lbound + "; rb: " + rbound);
			}
			return "YES";
		}
	}

	public static void main(String[] args) {
		int t, n;
		int r;

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			r = sc.nextInt();

			int[] a = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solver(a, n, r));
		}
		sc.close();
	}

}
