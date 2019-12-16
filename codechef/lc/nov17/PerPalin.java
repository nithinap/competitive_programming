package lc.nov17;

import java.util.Scanner;

public class PerPalin {

	private static String genPeriodic(int p) {
		StringBuilder sb = new StringBuilder();

		sb.append("a");
		for (int i = 0; i < p - 2; i++) {
			sb.append("b");
		}
		sb.append("a");

		return sb.toString();
	}

	public static void main(String[] args) {
		int t;
		int n, p;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			p = sc.nextInt();

			if (p < 3) {
				System.out.println("impossible");
			} else {
				String s = genPeriodic(p);
				for (int i=0; i<n/p; i++) {
					System.out.print(s);
				}
				System.out.println();
			}
		}

		sc.close();
	}

}
