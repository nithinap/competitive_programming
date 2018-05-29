package lc.apr18;

import java.util.Scanner;

public class GoodPref {
	public static void main(String[] args) {
		int t, n;
		String s;
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();
		while (t-- > 0) {
			s = sc.next();
			n = sc.nextInt();

			int len = s.length();

			int[] g = new int[len];
			int i = 0;
			int tota = 0, totb = 0;
			boolean valid = false;
			for (String ch : s.split("")) {
				if (ch.equals("a"))
					tota++;
				else
					totb++;
				g[i++] = tota - totb;
				if (g[i - 1] >= 0)
					valid = true;
			}

			long res = 0;
			if (valid) {
				if (n > 1) {
					if (tota > totb) { // p > 0
						int p = tota - totb;
						for (i = 0; i < len; i++) {
							if (g[i] <= 0) {
								g[i] = -1 * g[i];
								double rem = g[i] / (double) p;
								int cont = (rem % 1 == 0) ? (int) (rem + 1) : (int) Math.ceil(rem);
								if (n >= cont)
									res += (n - cont);
							} else {
								res += n;
							}
						}
					} else if (tota == totb) { // p = 0
						for (i = 0; i < len; i++) {
							if (g[i] > 0) {
								res += 1;
							}
						}
						res =  res * n;
					} else { // p < 0
						int p = totb - tota;
						for (i = 0; i < len; i++) {
							if (g[i] > 0) {
								double rem =  g[i] / (double) p;
								int cont = (int) Math.ceil(rem);
								if (cont <= n)
									res += cont;
								else if (cont > n)
									res += n;
							}
						}
					}
				} else {
					for (i = 0; i < len; i++) {
						if (g[i] > 0) {
							res += 1;
						}
					}
				}
			}

			System.out.println(res);
		}

		sc.close();
	}
}
